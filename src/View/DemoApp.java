/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import HadoopMini.MyMap;
import HadoopMini.MyReduce;
import HadoopMini.Tupla;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MapReduce.VersionTask.AbstractTask;

/**
 *
 * @author kanguro
 */
public class DemoApp extends AbstractTask {

	@Override
	public void map(Tupla elemento, ArrayList output) {
		Map1 map1 = new Map1();
		map1.map(elemento, output);
	}

	@Override
	public void reduce(Tupla elemento, ArrayList output) {
		 Reduce1 reduce1 = new Reduce1();
    reduce1.reduce(elemento, output);
	}
    
    public static class Map1 implements MyMap {
        @Override
        public void map(Tupla elemento, ArrayList output) {
            String line = String.valueOf(elemento.getValor());
            StringTokenizer tokenizer = new StringTokenizer(line);
            while(tokenizer.hasMoreTokens()) {
                String Dato = tokenizer.nextToken();
                //Solo si es de tipo 404
                if(Dato.equalsIgnoreCase("404")) {
                    output.add(new Tupla(Dato, 1));
                }
            }
        }
    }
    
    public static class Reduce1 implements MyReduce {
        @Override
        public void reduce(Tupla elemento, ArrayList output) {
            int suma = 0;
            ArrayList lstValores = (ArrayList)elemento.getValor();
            for (int j = 0; j < lstValores.size(); j ++) {
                suma+=(int)lstValores.get(j);
            }
            output.add(new Tupla(elemento.getClave(), suma));
        }
    }

    
}
