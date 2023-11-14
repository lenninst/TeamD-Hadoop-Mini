package Tasks;

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;


public class Task4 extends AbstractTask {
	
		@Override
	public void map(Tupla elemento, ArrayList output) {
		Task4.Map1 map1 = new Task4.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		 Task4.Reduce1 reduce1 = new Task4.Reduce1();
    reduce1.reduce(elemento, output);
	}

    
  public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            ArrayList<Double> values = (ArrayList<Double>) elemento.getValor();
            System.out.println("Paso 2: Map: Procesando MAP " + elemento.getClave());
            System.out.println("Línea procesada: " + values);

            // Verificar si hay al menos 3 elementos en la lista
            if (values.size() >= 3) {
                double surfaceTemperature = values.get(1);
                double windChill = values.get(2);
                System.out.println("Surface Temperature: " + surfaceTemperature);
                System.out.println("Wind Chill: " + windChill);

                // Emitir tupla clave-valor si surfaceTemperature es diferente de windChill
                if (surfaceTemperature != windChill) {
                    output.add(new Tupla(elemento.getClave(), surfaceTemperature - windChill));
                }
            }
        }
    }

    public static class Reduce1 implements MyReduce {
    @Override
    public void reduce(Tupla elemento, ArrayList output) {
        double suma = 0;
        ArrayList lstValores = (ArrayList) elemento.getValor();
        for (int j = 0; j < lstValores.size(); j++) {
            suma += (double) lstValores.get(j);
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
        t.setOutputFile("D:\\User\\GrupoD\\Filtered_data.csv");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 4 realizada");
    }
    
}
