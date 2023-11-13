/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;

/**
 *
 * @author Scarlet Gutierrez
 */
public class Task5 extends AbstractTask {

	@Override
	public void map(Tupla elemento, ArrayList output) {
		Task5.Map1 map1 = new Task5.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		Task5.Reduce1 reduce1 = new Task5.Reduce1();
		reduce1.reduce(elemento, output);
	}

	public static class Map1 implements MyMap {

		@Override
		public void map(Tupla elemento, ArrayList output) {
			String line = String.valueOf(elemento.getValor());
			// Antes de procesar los datos, imprime una línea del archivo de entrada
			System.out.println("Entrada: " + line);
			String[] fields = line.split(",");
			if (fields.length >= 11) {
				double rainfall = Double.parseDouble(fields[5].trim());
				double relativeHumidity = Double.parseDouble(fields[9].trim());
				double windChill = Double.parseDouble(fields[12].trim());

				if (rainfall > 0) {
					// Agrega una terna a la lista
					ArrayList<Double> terna = new ArrayList<>();
					terna.add(rainfall);
					terna.add(relativeHumidity);
					terna.add(windChill);
					output.add(new Tupla("terna", terna));
				}
			}
		}
	}

	public static class Reduce1 implements MyReduce {

		@Override
		public void reduce(Tupla elemento, ArrayList output) {
			output.add(elemento);
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
		t.setOutputFile("D:\\User\\GrupoD\\Filtered_weather_data.csv");
		t.setNodes(2);
		t.setMapFunction(new Task1.Map1());
		t.setReduceFunction(new Task1.Reduce1());
		t.Run();
		System.out.println("Prueba 5 realizada");
	}

}
