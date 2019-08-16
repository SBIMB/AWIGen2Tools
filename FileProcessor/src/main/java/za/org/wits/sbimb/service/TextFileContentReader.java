/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedom Mukomana
 *
 */
public class TextFileContentReader implements ITextFileContentReader{
	
	public List<String> getContentsByLine(FileReader fr){
		
		BufferedReader br = new BufferedReader(fr);
		String line=null;
		List<String> lineList = new ArrayList<String>();
		try {
			while((line = br.readLine())!= null){
				lineList.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineList;
	}
}
