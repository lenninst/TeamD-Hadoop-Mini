package Controller.Extractors;

/**
 *
 * @author Lenin Guaminga
 */
public class NumberExtractor {
	public static int parseNumberFromString (String textString) {
		String numberOnly = textString.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(numberOnly);
		
		return number;
	}
	
}
