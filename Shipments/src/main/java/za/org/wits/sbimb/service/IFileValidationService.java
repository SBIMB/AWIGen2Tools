/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.File;

import za.org.wits.sbimb.shipment.model.FileFormatNotValidException;
import za.org.wits.sbimb.shipment.model.FileStructureNotValidException;

/**
 * @author Freedom Mukomana
 *
 */
public interface IFileValidationService {
	Boolean isFileFormatCorrect(File file) throws FileFormatNotValidException;
	Boolean isFileStructureCorrect(File file) throws FileStructureNotValidException;
}
