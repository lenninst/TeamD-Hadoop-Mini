package Controller.Converters;

import MapReduce.VersionTask.AbstractTask;
import Tasks.Task1;
import Tasks.Task2;
import Tasks.Task3;
import Tasks.Task4;
import Tasks.Task5;
import Tasks.Task6;
import Tasks.Task7;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenin Guaminga
 */
public class DataItemConverter {

    public static AbstractTask parseTaskFromItem(String taskItemSelected) {
        Map<String, AbstractTask> taskMap = new HashMap<>();

        taskMap.put("Tarea 1", new Task1());
        taskMap.put("Tarea 2", new Task2());
        taskMap.put("Tarea 3", new Task3());
        taskMap.put("Tarea 4", new Task4());
        taskMap.put("Tarea 5", new Task5());
        taskMap.put("Tarea 6", new Task6());
        taskMap.put("Tarea 7", new Task7());


        String taskName = taskItemSelected;
        AbstractTask task = taskMap.get(taskName);

        return task;
    }
}