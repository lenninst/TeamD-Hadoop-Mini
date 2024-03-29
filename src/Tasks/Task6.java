package Tasks;

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;
/**
 *
 * @author Scarlet Gutierrez
 */
public class Task6 extends AbstractTask {

	@Override
	public void map(Tupla elemento, ArrayList output) {
		Task6.Map1 map1 = new Task6.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		Task6.Reduce1 reduce1 = new Task6.Reduce1();
		reduce1.reduce(elemento, output);
	}

    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            String[] fields = line.split(",");
            
            if (fields.length >= 15) {
                double maxTemperature = Double.parseDouble(fields[14].trim());
                double minTemperature = Double.parseDouble(fields[15].trim());
                
                // Crear tuplas para la temperatura máxima y mínima
                output.add(new Tupla("maxTemperature", maxTemperature));
                output.add(new Tupla("minTemperature", minTemperature));
            }
        }
    }
    
    
    
    public static class Reduce1 implements MyReduce {
        @Override
        public void reduce(Tupla elemento, ArrayList output) {
            output.add(elemento);
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
        t.setOutputFile("D:\\User\\GrupoD\\TemperatureData.csv");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 6 realizada");
    }
    
}
