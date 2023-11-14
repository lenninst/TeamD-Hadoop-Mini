package HadoopMini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejoArchivo {
    private String inputFile;
    private ArrayList<Tupla> tuplas;

    public ManejoArchivo(String inputFile) {
        this.inputFile = inputFile;
        this.tuplas = new ArrayList<>();
    }

    public ArrayList<ArrayList<Tupla>> generarBufferMappers(Integer nodes) {
        ArrayList<ArrayList<Tupla>> buffers = new ArrayList<>();
        ArrayList<Tupla> currentBuffer = new ArrayList<>();

        boolean isCSV = inputFile.toLowerCase().endsWith(".csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Dividir los datos de entrada y crear objetos Tupla
                String[] parts = line.split(",");

                if (isCSV) {
                    // Procesar como archivo CSV
                    if (parts.length >= 13) {
                        double rainfall = Double.parseDouble(parts[5].trim());
                        double relativeHumidity = Double.parseDouble(parts[9].trim());
                        double windChill = Double.parseDouble(parts[12].trim());

                        // Crear una terna y agregarla al buffer
                        ArrayList<Double> terna = new ArrayList<>();
                        terna.add(rainfall);
                        terna.add(relativeHumidity);
                        terna.add(windChill);
                        currentBuffer.add(new Tupla("terna", terna));
                    }
                } else {
                    // Procesar como archivo TXT
                    if (parts.length == 2) {
                        Object clave = parts[0];
                        Object valor = parts[1];
                        Tupla tupla = new Tupla(clave, valor);
                        currentBuffer.add(tupla);
                    }
                }

                if (currentBuffer.size() >= nodes.intValue()) {
                    buffers.add(new ArrayList<>(currentBuffer));
                    currentBuffer.clear();
                }
            }

            // Agregar el último buffer si no está vacío
            if (!currentBuffer.isEmpty()) {
                buffers.add(new ArrayList<>(currentBuffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Generados " + buffers.size() + " buffers.");
        return buffers;
    }

    
    
    
    public void llenarBufferSalida(ArrayList<Tupla> resultado) {
        this.tuplas.addAll(resultado);
    }
    
    

    
    public void escribirFichero(String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Tupla tupla : tuplas) {
                writer.write(tupla.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    
   public void ejecutar(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            ArrayList<Tupla> palabrasTristes = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");

                if (fields.length >= 8) {
                    String word = fields[0];
                    double happinessAverage = Double.parseDouble(fields[2].trim());
                    String twitterRank = fields[4].trim();

                    if (happinessAverage < 2.0 && !twitterRank.equals("--")) {
                        palabrasTristes.add(new Tupla("sadWord", word));
                    }
                }
            }

            // Llenar los buffers de salida con las palabras tristes
            llenarBufferSalida(palabrasTristes);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
  
}
