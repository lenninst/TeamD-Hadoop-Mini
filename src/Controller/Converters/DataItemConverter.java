package Controller.Converters;

import MapReduce.VersionTask.AbstractTask;
import View.DemoApp;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenin Guaminga
 */
public class DataItemConverter {

    public static AbstractTask parseTaskFromItem(String taskItemSelected) {
        Map<String, AbstractTask> taskMap = new HashMap<>();

        taskMap.put("Tarea 1", new DemoApp());

        String taskName = taskItemSelected;
        AbstractTask task = taskMap.get(taskName);

        return task;
    }
}