/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;

/**
 *
 * @author Scarlet Gutierrez
 */
public class Task2 extends AbstractTask {
		@Override
	public void map(Tupla elemento, ArrayList output) {
		Task2.Map1 map1 = new Task2.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		 Task2.Reduce1 reduce1 = new Task2.Reduce1();
    reduce1.reduce(elemento, output);
	}
     public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            StringTokenizer tokenizer = new StringTokenizer(line);
            while(tokenizer.hasMoreTokens()) {
                String Dato = tokenizer.nextToken();
                //Solo si es de tipo .gif
                if(Dato.indexOf(".gif")!=1) {
                    output.add(new Tupla("PeticionGIF", 1));
                }
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
        t.setOutputFile("D:\\User\\GrupoD\\Task2-weblogResult.txt");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 2 realizada");

    }
    
}
