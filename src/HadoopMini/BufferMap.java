/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HadoopMini;

import java.util.ArrayList;

/**
 *
 * @author Scarlet Gutierrez
 */
public class BufferMap {

    private ArrayList lstParticionada = new ArrayList();
    private ArrayList lstOrdenada = new ArrayList();

    
    public BufferMap() {
        
    }
    
    public ArrayList getLstParticionada() {
        return lstParticionada;
    }
    
    public void setLstParticionada(ArrayList lstParticionada) {
        this.lstParticionada = lstParticionada;
    }
    
    public ArrayList getLstOrdenada() {
        return lstOrdenada;
    }

    public void setLstOrdenada(ArrayList lstOrdenada) {
        this.lstOrdenada = lstOrdenada;
    }
    
    
    //PARTICIONAR
    public void particionarBuffer (ArrayList lstTuplas, int numNodes) {
        for (int i = 0; i < lstTuplas.size(); i ++) {
            Tupla tp = (Tupla)lstTuplas.get(i);
            int nodoReducer = (tp.getClave().hashCode()% numNodes);
            //Para rastrear la partición
            System.out.println("Tupla asignada a reducer " + nodoReducer + ": " + tp);
            lstParticionada.add(new Tupla(nodoReducer, tp));
        }
    }
    
    
    //ORDENADO
    public void ordenadoBuffer() {
        for (int i = 0; i < lstParticionada.size(); i ++) {
            Tupla tp = (Tupla)lstParticionada.get(i);
            Tupla tpParejaClaveValor = (Tupla)tp.getValor();
            int reducerDestino = (int)tp.getClave();
            int index = buscarBufferDeReducerEnListaOrdenada (reducerDestino);
            
            if (index!=-1) {
                BufferReducer bfr = (BufferReducer)lstOrdenada.get(index);
                bfr.agregarTuplaAlstTuplas (tpParejaClaveValor);
                lstOrdenada.set (index, bfr);
                //Para rastrear el ordenamiento
                System.out.println("Tupla agregada a reducer " + reducerDestino + ": " + tpParejaClaveValor);
            } else {
                ArrayList tmp = new ArrayList();
                ArrayList tmpLstValores = new ArrayList();
                tmpLstValores.add(tpParejaClaveValor.getValor());
                tmp.add(new Tupla (tpParejaClaveValor.getClave(), tmpLstValores));
                lstOrdenada.add(new BufferReducer (reducerDestino, tmp));
                //Para rastrear el ordenamiento
                System.out.println("Nuevo reducer " + reducerDestino + " creado con: " + tpParejaClaveValor);
                }
        }
    }
    
    public int buscarBufferDeReducerEnListaOrdenada (int reducer) {
        for (int i = 0; i < lstOrdenada.size(); i ++) {
            BufferReducer BufferReducer = (BufferReducer)lstOrdenada.get(i);
            if (BufferReducer.getNumReducer () == reducer)
                return i;
        }
        return -1;
    }
}
