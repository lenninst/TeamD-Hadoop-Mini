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
public class Task4 {
    
    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());

            // Dividir la línea en campos utilizando coma como separador
            String[] fields = line.split(",");
            if (fields.length >= 14) {
                String surfaceTemp = fields[8].trim();
                String windChill = fields[12].trim();

                // Compara la temperatura en superficie con la sensación térmica
                if (!surfaceTemp.equals(windChill)) {
                    System.out.println("Diferencia encontrada - Surface Temp: " + surfaceTemp + ", Wind Chill: " + windChill);
                    output.add(new Tupla("diferentes", line)); // Agregar la línea completa
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
        t.setOutputFile("D:\\User\\GrupoD\\Filtered_data.csv");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 4 realizada");
        //System.out.println("Filtrado completado. Datos guardados en " + t.getOutputFile());
    }
    
}
