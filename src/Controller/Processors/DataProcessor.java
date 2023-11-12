/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Processors;

import HadoopMini.Tarea;
import MapReduce.VersionTask.AbstractTask;


/**
 *
 * @author kanguro
 */
public class DataProcessor {

	
	public static void launchDataProcessor(AbstractTask taskSelected, String inputDirectory, String outputDirectory, int nodes) {
		
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir + "\n");

				if (taskSelected == null) {
        System.out.println("Error: taskSelected es nulo. No se puede ejecutar el procesamiento.");
        return;
    }

        Tarea t = new Tarea();
        t.setInputFile(inputDirectory);
        t.setOutputFile(outputDirectory);
        t.setNodes(nodes);
        t.setMapFunction((elemento , output) -> taskSelected.map(elemento, output));
        t.setReduceFunction((elemento, output) -> taskSelected.reduce(elemento, output));
        t.Run();
        System.out.println("Prueba 1 realizada");
    }
}
