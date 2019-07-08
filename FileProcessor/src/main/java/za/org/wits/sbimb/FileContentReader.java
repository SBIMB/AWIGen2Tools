/**
 * 
 */
package za.org.wits.sbimb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedom Mukomana
 *
 */
public class FileContentReader {
	
		
	FileReader getFile(String filePath){
		FileReader fr = null;
		 try {
			fr = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fr;
	}
	
	List<String> getContentsByLine(FileReader fr){
		
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
