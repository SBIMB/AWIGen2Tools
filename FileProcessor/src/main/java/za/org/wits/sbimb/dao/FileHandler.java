/**
 * 
 */
package za.org.wits.sbimb.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Freedom Mukomana
 *
 */
public class FileHandler {
	public File getFile(String filePath){
		File file = null;
		file = new File(filePath);		
		return file;
	}
		
	public FileReader getFileReader(String filePath){
		FileReader fr = null;
		 try {
			fr = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return fr;
	}
	
	
	
}
