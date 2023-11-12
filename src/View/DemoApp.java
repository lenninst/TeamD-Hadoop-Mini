/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import HadoopMini.MyMap;
import HadoopMini.MyReduce;
import HadoopMini.Tarea;
import HadoopMini.Tupla;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author kanguro
 */
public class DemoApp {
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
        t.setInputFile("D:\\1Univseridad Octavo semestre\\Arquitectura hibrida\\proyectogrupal\\Proyecto2HadoopMIni\\FRPB-AD-Unidad2-ProyectoCodigo2-Ficheros\\weblog.txt");
        t.setOutputFile("D:\\1Univseridad Octavo semestre\\Arquitectura hibrida\\proyectogrupal\\Proyecto2HadoopMIni\\FRPB-AD-Unidad2-ProyectoCodigo2-Ficheros\\trarea1.txt");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 1 realizada");
    }
    
}
