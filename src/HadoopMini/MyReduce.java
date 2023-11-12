/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HadoopMini;

import java.util.*;
/**
 *
 * @author Scarlet Gutierrez
 */
public interface MyReduce {
    public void reduce (Tupla elemento, ArrayList output);
}
