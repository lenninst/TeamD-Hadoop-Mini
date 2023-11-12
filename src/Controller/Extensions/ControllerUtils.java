/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Controller.Extensions;

/**
 *
 * @author kanguro
 */
public class ControllerUtils {
	
	public static int coreNumbers () {
		
		int physicalCores = Runtime.getRuntime().availableProcessors()/2;
		int logicalCores = Runtime.getRuntime().availableProcessors();
		
		return physicalCores * logicalCores;
	}
	
}
