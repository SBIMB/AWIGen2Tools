/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;

/**
 * @author Freedom Mukomana
 *
 */
public class SpreadsheetContentReader implements ISpreadsheetContentReader {

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getWorkBook(java.io.File)
	 */
	public Workbook getWorkBook(File file) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		 // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(file);
		return workbook;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getWorksheets(org.apache.poi.ss.usermodel.Workbook)
	 */
	public HashMap<String, Sheet> getWorksheets(Workbook workbook) {
		
		HashMap<String, Sheet> worksheets = new HashMap<String, Sheet>();
		
		// Obtain a sheetIterator and iterate over it
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            worksheets.put(sheet.getSheetName(), sheet);
        }
		return worksheets;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getRows(org.apache.poi.ss.usermodel.Sheet)
	 */
	public List<Row> getRows(Sheet sheet) {
		ArrayList<Row> rows = new ArrayList<Row>();
		
		Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            
           rows.add(row);
        }
		return rows;
	}
	
	

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getCells(org.apache.poi.ss.usermodel.Workbook, org.apache.poi.ss.usermodel.Row)
	 */
	@Override
	public HashMap<String, String> getCells(Workbook workbook, Row row) {
		// TODO Auto-generated method stub
		return null;
	}
		
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getCells(org.apache.poi.ss.usermodel.Workbook, java.util.List, org.apache.poi.ss.usermodel.Row)
	 */
	@Override
	public HashMap<String, String> getCells(Workbook workbook,
			List<String> cellAddresses, List<String> cellHeaders, Row row) {
		
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = null; 
		HashMap<String, String> cells = new HashMap<String, String>();

		// Now let's iterate over the columns of the current row
        Iterator<Cell> cellIterator = row.cellIterator();
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();        
        int index = 0;
        
        while (cellIterator.hasNext()) {
        	Cell cell = cellIterator.next();
            //System.out.println(cell.getSheet().getSheetName()+" "+cell.getAddress());
            
            if(cellAddresses.contains(cell.getAddress().formatAsString().toUpperCase())){
            	cellAddresses.indexOf(cell.getAddress().formatAsString().toUpperCase());
            	if(cell!=null || cell.getCellTypeEnum()!=CellType.BLANK || cell.getCellTypeEnum()!=CellType.STRING || cell.getStringCellValue()!="" ){
            		CellValue cv = evaluator.evaluate(cell);
	                CellType cellType=null;
	                
	                if(cv!=null)
	                	cellType = cv.getCellTypeEnum();	                             
	                	
	                   	if(cellType!=null){
	                   		switch (cellType) {
				               	case STRING:
				               		cellValue = cell.getStringCellValue();
				               		break;
				
			                	case FORMULA:
			                		cellValue = cell.getCellFormula();
			                		break;
				
			                	case NUMERIC:
				                	if (DateUtil.isCellDateFormatted(cell)) {
				                        cellValue = cell.getDateCellValue().toString();
				                    } else {
				                        cellValue = Double.toString(cell.getNumericCellValue());
				                    }
				                    break;
				
			                	case BLANK:
				                    cellValue = "";
				                    break;
				
				                case BOOLEAN:
				                    cellValue = Boolean.toString(cell.getBooleanCellValue());
				                    break;
					                    
				                default:
				                	cellValue ="";
				                	break;
				               }
	                   		}
	                	}else{
	                		cellValue="";
	                	}   
	                	//String cellValue = dataFormatter.formatCellValue(cell);
	                	
	                cells.put(cellHeaders.get(index), cellValue);
	                }
	            }
           
		return cells;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getCells(org.apache.poi.ss.usermodel.Row)
	 */
	public HashMap<String, String> getCells(Workbook workbook, HashMap<CellAddress, String> cellHeaders, Row row) {
		
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue = null; 
		HashMap<String, String> cells = new HashMap<String, String>();

		 // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            
        

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //System.out.println(cell.getSheet().getSheetName()+" "+cell.getAddress());
                if(cell!=null || cell.getCellTypeEnum()!=CellType.BLANK || cell.getCellTypeEnum()!=CellType.STRING || cell.getStringCellValue()!="" ){
                	CellValue cv = evaluator.evaluate(cell);
                	CellType cellType=null;
                	if(cv!=null)
                		cellType = cv.getCellTypeEnum();
                //Character column = cell.getAddress().toString().charAt(0);
                
                for(Map.Entry<CellAddress, String> cellHeader : cellHeaders.entrySet()){
                	//System.out.println(cellHeader.getKey().getColumn()+" "+cell.getColumnIndex());
                	if(cellHeader.getKey().getColumn()==cell.getColumnIndex()){
                   		if(cellType!=null){
                   			switch (cellType) {
			                	case STRING:
			                		cellValue = cell.getStringCellValue();
			                		break;
			
			                	case FORMULA:
			                		cellValue = cell.getCellFormula();
			                		break;
			
			                	case NUMERIC:
				                	if (DateUtil.isCellDateFormatted(cell)) {
				                        cellValue = cell.getDateCellValue().toString();
				                    } else {
				                        cellValue = Double.toString(cell.getNumericCellValue());
				                    }
				                    break;
			
			                	case BLANK:
				                    cellValue = "";
				                    break;
			
				                case BOOLEAN:
				                    cellValue = Boolean.toString(cell.getBooleanCellValue());
				                    break;
				                    
				                default:
				                	cellValue ="";
				                	break;
			                }
                   		}
                   		//System.out.println(cellHeader.getValue()+" "+ cellValue);
                	}else{
                		cellValue="";
                	}   
                	//String cellValue = dataFormatter.formatCellValue(cell);
                	
                cells.put(cellHeader.getValue(), cellValue);
                }
                }
            }
		return cells;
	}	

	@Override
	public HashMap<CellAddress, String> getWorksheetHeader(Row row) {
		
		DataFormatter dataFormatter = new DataFormatter();
		HashMap<CellAddress, String> worksheetHeader = new HashMap<CellAddress, String>();
		
		// Now let's iterate over the columns of the current row
        Iterator<Cell> cellIterator = row.cellIterator();
        
		while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if(cell.getCellTypeEnum()!=CellType.BLANK){
            	String cellValue = dataFormatter.formatCellValue(cell);
            	worksheetHeader.put(cell.getAddress(), cellValue);
            	//System.out.println(cell.getAddress()+" "+ cellValue);
            }
        }
		return worksheetHeader;
	}

	@Override
	public HashMap<String, String> mapValuesToHeader(HashMap<CellAddress, String> header,
			HashMap<CellAddress, String> row) {
		HashMap<String, String> record = new HashMap<String, String>();
		int i = 0;
		
		// Now let's iterate over the columns of the current row
        Iterator<Entry<CellAddress, String>> cellIterator = row.entrySet().iterator();
        
        while (cellIterator.hasNext()) {
            Map.Entry<CellAddress, String> cell = cellIterator.next();
            //System.out.println(header.get(i)+ " "+ cell.getValue().toString());
            record.put(header.get(i), cell.getValue().toString());
            i++;
        }
		
        
        return record;
	}

}
