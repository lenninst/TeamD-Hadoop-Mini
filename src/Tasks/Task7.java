package Tasks; 

import java.util.*;
import HadoopMini.*;
import MapReduce.VersionTask.AbstractTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class Task7 extends AbstractTask {

	@Override
	public void map(Tupla elemento, ArrayList output) {
		Task7.Map1 map1 = new Task7.Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		Task7.Reduce1 reduce1 = new Task7.Reduce1();
		reduce1.reduce(elemento, output);
	}

   public static class Map1 implements MyMap {
    @Override
    public void map(Tupla elemento, ArrayList<Tupla> output) {
        String line = String.valueOf(elemento.getValor());
        System.out.println("Línea completa: " + line);
        // Verificar si la línea tiene al menos ocho tokens
            String[] tokens = line.trim().split("\\s+");
            System.out.println("Tokens: " + Arrays.toString(tokens));

            if (tokens.length >= 8 && !tokens[0].isEmpty()) {
                System.out.println("La línea no tiene al menos ocho tokens. Ignorando línea: " + line);
                return;
            }

            // Definir el patrón de la línea
            String pattern = "(\\w+)\\s+(\\d+)(?:\\s+(\\d+)(?:\\s+(\\d+)(?:\\s+(\\d+)(?:\\s+(\\d+)(?:\\s+(\\d+))?)?)?)?)?";
            Pattern r = Pattern.compile(pattern);
            Matcher matcher = r.matcher(line);

            // Verificar si el patrón coincide con la línea
            if (matcher.find()) {
                try {
                    String word = matcher.group(1);
                    int happiness_average = Integer.parseInt(matcher.group(3));
                    String twitter_rank_str = matcher.group(5);

                    // Verificar si la felicidad media está por debajo de 2 y hay un ranking de Twitter
                    if (happiness_average < 2) {
                        // Verificar si tiene ranking de Twitter
                        if (!"--".equals(matcher.group(5))) {
                            // Agregar la palabra a la salida
                            output.add(new Tupla("sadWord", word));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Los valores no son números en la línea: " + line);
                    System.out.println("Línea completa: " + line);
                }

            } else {
                System.out.println("La línea no cumple con los requisitos. Ignorando línea: " + line);
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
        t.setInputFile("C:\\Users\\kanguro\\Desktop\\files\\happiness.txt");
        t.setOutputFile("D:\\User\\GrupoD\\extremely_sad_words.txt");
        t.setNodes(2);
        t.setMapFunction(new Map1());
        t.setReduceFunction(new Reduce1());
        t.Run();
        System.out.println("Prueba 7 realizada");



        ManejoArchivo archivoHandler = new ManejoArchivo("C:\\Users\\kanguro\\Desktop\\files\\happiness.txt");
        archivoHandler.ejecutar("C:\\Users\\kanguro\\Desktop\\files\\happiness.txt");
        archivoHandler.escribirFichero("D:\\User\\GrupoD\\extremely_sad_words.txt");
    }
	}



