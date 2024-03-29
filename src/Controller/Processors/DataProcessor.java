package Controller.Processors;

import HadoopMini.ManejoArchivo;
import HadoopMini.Tarea;
import MapReduce.VersionTask.AbstractTask;
import Tasks.Task7;

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
		t.setMapFunction((elemento, output) -> taskSelected.map(elemento, output));
		t.setReduceFunction((elemento, output) -> taskSelected.reduce(elemento, output));
		
		if (taskSelected instanceof Task7) {

		System.out.println(">_esta es la tarea 7");
			ManejoArchivo archivoHandler = new ManejoArchivo(outputDirectory);
			archivoHandler.ejecutar(inputDirectory);
			archivoHandler.escribirFichero(outputDirectory);
		}
		
		t.Run();
		System.out.println("Prueba realizada");

	}
}
