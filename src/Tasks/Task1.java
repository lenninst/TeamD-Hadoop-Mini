/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.util.*;
import HadoopMini.*;

/**
 *
 * @author Scarlet Gutierrez
 */
public class Task1 {
    //extends MapFunction
    
    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            StringTokenizer tokenizer = new StringTokenizer(line);
            while(tokenizer.hasMoreTokens()) {
                String Dato = tokenizer.nextToken();
                //Solo si es de tipo 404
                if(Dato.equalsIgnoreCase("404")) {
                    output.add(new Tupla(Dato, 1));
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
        t.setInputFile("D:\\1s\\weblog.txt");
        t.setOutputFile("D:\\1trarea1.txt");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 1 realizada");
    }
    
}
