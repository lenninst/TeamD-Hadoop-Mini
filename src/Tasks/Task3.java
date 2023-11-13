/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;


import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Scarlet Gutierrez
 */
public class Task3 extends AbstractTask {
		@Override
	public void map(Tupla elemento, ArrayList output) {
		Task3.Map1 map1 = new Task3.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		 Task3.Reduce1 reduce1 = new Task3.Reduce1();
    reduce1.reduce(elemento, output);
	}

    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            
            // Utiliza una expresión regular para buscar la hora en el formato [HH:mm:ss:ms]
            Pattern pattern = Pattern.compile("\\[(\\d{2}):(\\d{2}):(\\d{2}):(\\d{2})\\]");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String hora = "[" + matcher.group(1) + ":" + matcher.group(2) + "]";
                output.add(new Tupla(hora, 1));
                System.out.println("Hora encontrada: " + hora);
            }
        }
    }
    
    
    
    public static class Reduce1 implements MyReduce {
        @Override
        public void reduce(Tupla elemento, ArrayList output) {
            int suma = 0;
            ArrayList lstValores = (ArrayList)elemento.getValor();
            for (int j = 0; j < lstValores.size(); j ++) {
                suma+=(int)lstValores.get(j);
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
        t.setInputFile("D:\\User\\GrupoD\\weblog.txt");
        t.setOutputFile("D:\\User\\GrupoD\\Task3-weblogResult.txt");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 3 realizada");
    }
    
}
