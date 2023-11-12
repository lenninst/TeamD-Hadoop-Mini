/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Processors;

import HadoopMini.Tarea;
import Tasks.Task1.Map1;
import Tasks.Task1.Reduce1;

/**
 *
 * @author kanguro
 */
public class DataProcessor {

	
	public static void launchDataProcessor(String inputDirectory, String outputDirectory, int nodes) {
		
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir + "\n");

        Tarea t = new Tarea();
        t.setInputFile(inputDirectory);
        t.setOutputFile(outputDirectory);
        t.setNodes(nodes);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 1 realizada");
    }
}
