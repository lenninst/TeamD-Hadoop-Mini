package MapReduce.VersionTask;

import HadoopMini.Tupla;
import View.DemoApp;
import java.util.ArrayList;

/**
 *
 * @author Lenin Guaminga
 */
public abstract class AbstractTask {

    public abstract void map(Tupla elemento, ArrayList output);

    public abstract void reduce(Tupla elemento, ArrayList output);

    public static AbstractTask createTask(String taskName) {
        switch (taskName) {
            case "Task1":
                return new DemoApp();
								
            // Agrega más casos según sea necesario para otras tareas

            default:
                return null;
        }
    }


	}
