/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import za.org.wits.sbimb.shipment.model.FileFormatNotValidException;
import za.org.wits.sbimb.shipment.model.FileStructureNotValidException;

/**
 * @author Freedom Mukomana
 *
 */
public class FileValidationService implements IFileValidationService{
	
	ISpreadsheetContentReader iscr = new SpreadsheetContentReader();
	Workbook workbook = null;
	HashMap<String, Sheet> sheets = null;
	
	@Override
	public Boolean isFileFormatCorrect(File file) throws FileFormatNotValidException{
		String fileName = file.getName();
		String fileExtension = null;
		Boolean isFileFormatCorrect = null;
		
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
			fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
			
	        if(fileExtension.equalsIgnoreCase("xlsm")){
	        	isFileFormatCorrect=true;
	        }else{
	        	throw new FileFormatNotValidException("File format incorrect. Expect file format is xlsm but the current file is in "+ fileExtension);
	        }
		}else{
			throw new FileFormatNotValidException("File format incorrect. Expect file format is xlsm but the application could not determine the file type");
		};
		return isFileFormatCorrect;
	}

	@Override
	public Boolean isFileStructureCorrect(File file) throws FileStructureNotValidException, EncryptedDocumentException, InvalidFormatException, IOException {
		Boolean isFileStructureCorrect = false;
		Boolean isSummarySheetMissing=false;
		Boolean isParticipantsSheetMissing=false;
		Boolean isBiospecimenSheetMissing=false;
				
		try {
			workbook = iscr.getWorkBook(file);
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			throw e;
		}
		
		sheets = iscr.getWorksheets(workbook);
		
		if(!sheets.containsKey("Container Report and Sample Man")){
			isSummarySheetMissing=true;
		}
		
		if(!sheets.containsKey("Participants")){
			isParticipantsSheetMissing=true;
		}
		if(!sheets.containsKey("Plate 1 (10x10)")){
			isBiospecimenSheetMissing=true;
		}
		
		if(isSummarySheetMissing && isParticipantsSheetMissing && isBiospecimenSheetMissing){
			throw new FileStructureNotValidException("The manifest summary, participants and biospecimen worksheet are missing.");
		}else if(isSummarySheetMissing && isParticipantsSheetMissing){
			throw new FileStructureNotValidException("The manifest summary and participants worksheet are missing.");
		}else if(isSummarySheetMissing && isBiospecimenSheetMissing){
			throw new FileStructureNotValidException("The manifest summary and at least one biospecimen worksheets are missing.");
		}else if(isParticipantsSheetMissing && isBiospecimenSheetMissing){
			throw new FileStructureNotValidException("The participants and at least one biospecimen worksheets are missing.");
		}else if(isSummarySheetMissing){
			throw new FileStructureNotValidException("The summary worksheet is missing.");
		}else if(isParticipantsSheetMissing){
			throw new FileStructureNotValidException("The participants worksheet is missing.");
		}else if(isBiospecimenSheetMissing){
			throw new FileStructureNotValidException("The biospecimen worksheet is missing.");
		}else{
			isFileStructureCorrect=true;
		}		
		return isFileStructureCorrect;
	}
}
