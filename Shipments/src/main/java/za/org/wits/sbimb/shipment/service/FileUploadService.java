/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import za.org.wits.sbimb.dao.FileHandler;
import za.org.wits.sbimb.service.FileValidationService;
import za.org.wits.sbimb.service.ImportFromSpreadsheet;
import za.org.wits.sbimb.service.SpreadsheetContentReader;
import za.org.wits.sbimb.shipment.model.DataError;
import za.org.wits.sbimb.shipment.model.Feedback;
import za.org.wits.sbimb.shipment.model.FileFormatNotValidException;
import za.org.wits.sbimb.shipment.model.FileStructureNotValidException;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;
import za.org.wits.sbimb.shipment.service.IDataValidationService;

/**
 * @author Freedom Mukomana
 *
 */
public class FileUploadService implements IFileUploadService {
	FileValidationService fileValidationService = new FileValidationService();
	FileHandler fileHandler = new FileHandler();
	ImportFromSpreadsheet ims = new ImportFromSpreadsheet();
	SpreadsheetContentReader scr = new SpreadsheetContentReader();
	IDataValidationService dataValidationService = new DataValidationService();
	File file;
	Workbook workbook;
	ShipmentManifest shipmentManifest;
	
	
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
			feedback.setIsError(true);
			feedback.setNote(e.getMessage());
			return feedback;
		}
		
		//Checks file structure
		try {
			fileValidationService.isFileStructureCorrect(file);			
		} catch (FileStructureNotValidException | EncryptedDocumentException | InvalidFormatException | IOException e) {
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
		shipmentManifest = ims.convert(workbook);

		return shipmentManifest;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IFileUploadService#postStepTwo()
	 */
	@Override
	public Feedback postStepTwo() {
		Feedback feedback = null;
		List<DataError> shipmentManifestDataErrors = dataValidationService.checkManifestErrors(shipmentManifest);
		
		if(shipmentManifestDataErrors.size()==0){
			feedback = new Feedback(false);
		}else{
			StringBuilder sb = new StringBuilder();
			shipmentManifestDataErrors.forEach(dataError->{
				sb.append(dataError.getMessage());
				sb.append("\n");
			});
			feedback = new Feedback(true, sb.toString());
			System.out.println(sb.toString());
		}
		
		return feedback;
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
