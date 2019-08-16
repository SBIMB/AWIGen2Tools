/**
 * 
 */
package za.org.wits.sbimb.awigen.spirometry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import za.org.wits.sbimb.awigen.spirometry.util.Xml2CsvConverter;

/**
 * @author Freedom Mukomana
 *
 */
public class Spirometry {

	/**
	 * @param args
	 */
	Xml2CsvConverter xml2CsvConverter = new Xml2CsvConverter();
	public static void main(String[] args) {
		Spirometry spirometry = new Spirometry();
						
		spirometry.convertXmlToCsv();
	}
	
	void countBeforeValidBlows(List<String> lines){
		
		List<List<String>> participantBlows = new ArrayList<List<String>>();
		
		for(String line:lines){
			String[] arrayStr = line.split(",");
			int validBlow = 0;
			int count = 0;
			List<String> numOfBlows = new ArrayList<String>();
			for(String s:arrayStr){
				count++;
				if(s.equals(1)){
					validBlow++;
					
					if(validBlow==3){
						numOfBlows.add(arrayStr[0]);
						numOfBlows.add(String.valueOf(count));
						System.out.println(arrayStr[0] +" "+ count);
					}
				}
			}
			participantBlows.add(numOfBlows);
		}
		
	}
	
	void convertXmlToCsv(){
		String filePath = "C:/Users/A0035863/Documents/SBIMB/AWI-Gen/AWIGen2/DIMAMO/Spirometry/Dimamo_2019-07-10.xml";
		String output = null;
		//Get XML file to convert
		File xmlSourceFile = xml2CsvConverter.getXmlFile(filePath);
		
		output=xml2CsvConverter.convert(xmlSourceFile, "file");
	}

}
