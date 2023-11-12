/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HadoopMini;

//import Tasks.Task1;
import Tasks.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Scarlet Gutierrez
 */
public class Tarea {
    private String InputFile = "";
    private String OutputFile = "";
    private Integer Nodes = 0;
    
    private MyMap MapFunction;
    private MyReduce ReduceFunction;
    private Object CombinerFunction = "";
    
    public Tarea(){
        super();
        InputFile = "";
        OutputFile = "";
        Nodes = 0;
        MapFunction = null;
        ReduceFunction = null;
        CombinerFunction = "";
    }
    
    public Tarea (String inputFile, String outputFile, Integer nodes, 
            MyMap mapFunction, MyReduce reduceFunction, Object combinerFunction){
        super();
        InputFile = inputFile;
        OutputFile = outputFile;
        Nodes = nodes;
        MapFunction = mapFunction;
        ReduceFunction = reduceFunction;
        CombinerFunction = combinerFunction;
    }
    
    @Override
    public String toString() {
        return "Tarea [InputFile = " + InputFile
                + ", OutputFile = " + OutputFile 
                + ", Nodes = " + Nodes
                + ", MapFunction = " + MapFunction
                + ", ReduceFunction = " + ReduceFunction
                + ", CombinerFunction = " + CombinerFunction + "]";
    }

    
    
    public String getInputFile() {
        return InputFile;
    }
    
    public void setInputFile(String inputFile) {
        InputFile = inputFile;
    }
    
    public String getOutputFile() {
        return OutputFile;
    }
    
    public void setOutputFile(String outputFile) {
        OutputFile = outputFile;
    }
    
    public Integer getNodes() {
        return Nodes;
    }
    
    public void setNodes(Integer nodes) {
        Nodes = nodes;
    }
    
    
    public MyMap getMapFunction() {
        return MapFunction;
    }

    public void setMapFunction(MyMap MapFunction) {
        this.MapFunction = MapFunction;
    }

    public MyReduce getReduceFunction() {
        return ReduceFunction;
    }

    public void setReduceFunction(MyReduce ReduceFunction) {
        this.ReduceFunction = ReduceFunction;
    }

    public Object getCombinerFunction() {
        return CombinerFunction;
    }

    public void setCombinerFunction(Object CombinerFunction) {
        this.CombinerFunction = CombinerFunction;
    }
 
    
    public void Run() {
        ManejoArchivo m = new ManejoArchivo(this.getInputFile());
        ArrayList lstBuffers = m.generarBufferMappers(this.getNodes());
        BufferMap bfm = new BufferMap();
        ArrayList resultado = new ArrayList();
        
        for (int i = 0; i < lstBuffers.size(); i++) {
            System.out.println("Paso 2: Map: Procesando MAP " + Integer.toString(i+1));
            ArrayList BufferDeCadaMap = (ArrayList) lstBuffers.get(i);
            ArrayList output = new ArrayList();
            
            for (int j = 0; j < BufferDeCadaMap.size(); j ++) {
                Tupla tp = (Tupla)BufferDeCadaMap.get(j);
                MapFunction.map(tp, output);
                System.out.println("Paso 2: MAP " + Integer.toString(i+1) 
                        + "genero buffer del tamaño " + output);
                bfm.particionarBuffer(output, this.getNodes());
            }
            
            bfm.ordenadoBuffer();
            
            ArrayList lstOrdenada = (ArrayList)bfm.getLstOrdenada();
            
            for(int e = 0; e < lstOrdenada.size(); e++) {
                BufferReducer br = (BufferReducer) lstOrdenada.get(e);
                System.out.println("Paso 3: Reduce: Procesando REDUCE " 
                        + br.getNumReducer());
                ArrayList lstTuplasReducer = (ArrayList)br.getLstTuplas();
                for (int j = 0; j < lstTuplasReducer.size(); j ++) {
                    Tupla tp = (Tupla) lstTuplasReducer.get(j);
                    System.out.println(tp);
                    ReduceFunction.reduce(tp, resultado);
                }
            }
            
            m.llenarBufferSalida(resultado);
            m.escribirFichero(this.OutputFile);
        }
    }


}
