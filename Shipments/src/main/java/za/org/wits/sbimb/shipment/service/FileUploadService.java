/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import za.org.wits.sbimb.dao.FileHandler;
import za.org.wits.sbimb.service.FileValidationService;
import za.org.wits.sbimb.service.ImportFromSpreadsheet;
import za.org.wits.sbimb.service.SpreadsheetContentReader;
import za.org.wits.sbimb.shipment.model.Feedback;
import za.org.wits.sbimb.shipment.model.FileFormatNotValidException;
import za.org.wits.sbimb.shipment.model.FileStructureNotValidException;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public class FileUploadService implements IFileUploadService {
	FileValidationService fileValidationService = new FileValidationService();
	FileHandler fileHandler = new FileHandler();
	ImportFromSpreadsheet ims = new ImportFromSpreadsheet();
	SpreadsheetContentReader scr = new SpreadsheetContentReader();
	File file;
	Workbook workbook;
	
	
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#preStepOne(java.lang.String)
	 */
	@Override
	public Feedback preStepOne(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#step_one()
	 */
	@Override
	public Feedback postStepOne(String filePath) {
		Feedback feedback = new Feedback(false,"File type and format seems to be fine.");		
		
		File file = fileHandler.getFile(filePath);
		
		//Check file format
		try {
			fileValidationService.isFileFormatCorrect(file);
		} catch (FileFormatNotValidException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
			return feedback;
		}
		
		//Checks file structure
		try {
			fileValidationService.isFileStructureCorrect(file);			
		} catch (FileStructureNotValidException | EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
			return feedback;
		}
		
		try {
			workbook = scr.getWorkBook(file);
		} catch (EncryptedDocumentException e) {
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
		} catch (InvalidFormatException e) {
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
		} catch (IOException e) {
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
		}
		
		return feedback;		
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#preStepTwo()
	 */
	@Override
	public ShipmentManifest preStepTwo() {
		ShipmentManifest shipmentManifest = ims.convert(workbook);
		
		return shipmentManifest;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#postStepTwo()
	 */
	@Override
	public Feedback postStepTwo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#preStepThree()
	 */
	@Override
	public Feedback preStepThree() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#postStepThree()
	 */
	@Override
	public Feedback postStepThree() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#preStepFour()
	 */
	@Override
	public Feedback preStepFour() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#postStepFour()
	 */
	@Override
	public Feedback postStepFour() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#preStepFive()
	 */
	@Override
	public Feedback preStepFive() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#postStepFive()
	 */
	@Override
	public Feedback postStepFive() {
		// TODO Auto-generated method stub
		return null;
	}
}
