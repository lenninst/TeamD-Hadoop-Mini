/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Utils;

import java.util.ArrayList;

/**
 *
 * @author kanguro
 */
public class ComboBoxUtils {
	public String nodeSelected;
	
	public static ArrayList<String> nodeGenerator (int nodesNumber) {
	ArrayList<String> nodeElement = new ArrayList<>();
        for (int i = 1; i <= nodesNumber; i++) {
            nodeElement.add("Nodo " + i);
        }	
				return nodeElement;
	}

 public String getNodeSelected () {
	 return nodeSelected;
 }
}
