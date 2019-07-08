/**
 * 
 */
package za.org.wits.sbimb.awigen.spirometry;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Freedom Mukomana
 *
 */
public class Spirometry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spirometry spirometry = new Spirometry();
		
		
		
		//spirometry.countBeforeValidBlows(lines);
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

}
