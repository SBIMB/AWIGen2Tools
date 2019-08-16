/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.FileReader;
import java.util.List;

/**
 * @author Freedom Mukomana
 *
 */
public interface ITextFileContentReader {
	public List<String> getContentsByLine(FileReader fr);
}
