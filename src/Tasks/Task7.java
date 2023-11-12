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
public class Task7 {

    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            String[] fields = line.split("\t");

            if (fields.length >= 8) {
                String word = fields[0];
                double happinessAverage = Double.parseDouble(fields[2].trim());
                String twitterRank = fields[4].trim();

                System.out.println("Word: " + word + ", Happiness Average: " + happinessAverage + ", Twitter Rank: " + twitterRank);

                if (happinessAverage < 2.0 && !twitterRank.equals("--")) {
                    // Agregar la palabra a la lista de palabras extremadamente tristes
                    output.add(new Tupla("sadWord", word));
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
        t.setInputFile("D:\\User\\GrupoD\\happiness.txt"); // Reemplaza con la ruta correcta
        t.setOutputFile("D:\\User\\GrupoD\\extremely_sad_words.txt"); // Reemplaza con la ruta correcta
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 7 realizada");
        
        // Llamar al método ejecutar de ManejoArchivo para procesar los resultados
        ManejoArchivo archivoHandler = new ManejoArchivo("D:\\User\\GrupoD\\extremely_sad_words.txt");
        archivoHandler.ejecutar("D:\\User\\GrupoD\\happiness.txt");
        archivoHandler.escribirFichero("D:\\User\\GrupoD\\extremely_sad_words.txt");
    }
    
}
