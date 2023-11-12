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
public class BufferReducer {
    private int numReducer;
    private ArrayList lstTuplas = new ArrayList();

    public BufferReducer (int numReducer, ArrayList lstTuplas) {
        super();
        this.numReducer = numReducer;
        this.lstTuplas = lstTuplas;
    }
    
    public int getNumReducer() {
        return numReducer;
    }

    public void setNumReducer(int numReducer) {
        this.numReducer = numReducer;
    }

    public ArrayList getLstTuplas() {
        return lstTuplas;
    }

    public void setLstTuplas(ArrayList lstTuplas) {
        this.lstTuplas = lstTuplas;
    }
    
    
    public int buscarTuplaEnLst (Tupla tp) {
        for (int i = 0; i < lstTuplas.size(); i ++){
            Tupla tptmp = (Tupla) lstTuplas.get(i);
            String claveTpTmp = (String)tptmp.getClave();
            if (claveTpTmp.compareTo ((String)tp.getClave()) == 0)
                return i;
        }
        return -1;
    }
    
    
    public void agregarTuplaAlstTuplas (Tupla tp) {
        int index = buscarTuplaEnLst (tp);
            if (index!=-1) {
            Tupla tptmp = (Tupla)lstTuplas.get(index);
            ArrayList lstTmp = (ArrayList)tptmp.getValor();
            lstTmp.add(tp.getValor());
            lstTuplas.set(index, new Tupla(tp.getClave(), lstTmp));
        } else{
                ArrayList lstTmp = new ArrayList();
                lstTmp.add(tp.getValor());
                lstTuplas.add(new Tupla (tp.getClave(), lstTmp));
            }
    }
    
    
    @Override
    public String toString() {
        return "(" + this.numReducer + " , " + this.lstTuplas + ")";
    }
}
