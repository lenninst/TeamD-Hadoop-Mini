package Tasks;

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;

public class Task5 extends AbstractTask {

	@Override
	public void map(Tupla elemento, ArrayList output) {
		Task5.Map1 map1 = new Task5.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		Task5.Reduce1 reduce1 = new Task5.Reduce1();
		reduce1.reduce(elemento, output);
	}

	  public static class Map1 implements MyMap {

        @Override
        public void map(Tupla elemento, ArrayList output) {
            ArrayList<Double> values = (ArrayList<Double>) elemento.getValor();

            // Verificar que la lista tenga al menos 3 elementos
            if (values.size() < 3) {
                output.add(new Terna(null, null, null));
            } else {
                Double rainfallAsDouble = Double.valueOf(values.get(2));
                if (rainfallAsDouble == null) {
                    output.add(new Terna(null, null, null));
                } else {
                    // Limitar el índice a 5 o al último elemento de la lista
                    double relativeHumidity = values.get(Math.min(5, values.size() - 1));
                    // Limitar el índice a 10 o al último elemento de la lista
                    double windChill = values.get(Math.min(10, values.size() - 1));
                    
                    output.add(new Terna(rainfallAsDouble, relativeHumidity, windChill));
                }
            }
        }
    }

    public static class Reduce1 implements MyReduce {
        @Override
        public void reduce(Tupla elemento, ArrayList output) {
            int suma = 0;
            ArrayList lstValores = (ArrayList) elemento.getValor();
            for (int j = 0; j < lstValores.size(); j++) {
                suma += (int) lstValores.get(j);
            }
            output.add(new Tupla(elemento.getClave(), suma));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir + "\n");
        
        Tarea t = new Tarea();
        t.setInputFile("D:\\User\\GrupoD\\JCMB_last31days.csv");
        t.setOutputFile("D:\\User\\GrupoD\\Filtered_weather_data.csv");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());

        t.Run();
        System.out.println("Prueba 5 realizada");

    }

}
