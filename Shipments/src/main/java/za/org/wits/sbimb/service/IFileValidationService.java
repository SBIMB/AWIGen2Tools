/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import za.org.wits.sbimb.shipment.model.FileFormatNotValidException;
import za.org.wits.sbimb.shipment.model.FileStructureNotValidException;

/**
 * @author Freedom Mukomana
 *
 */
public interface IFileValidationService {
	Boolean isFileFormatCorrect(File file) throws FileFormatNotValidException;
	Boolean isFileStructureCorrect(File file) throws FileStructureNotValidException, EncryptedDocumentException, InvalidFormatException, IOException;
}
