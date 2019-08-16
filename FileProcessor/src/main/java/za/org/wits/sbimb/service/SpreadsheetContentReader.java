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
import org.apache.poi.ss.usermodel.DataFormatter;
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
	 * @see za.org.wits.sbimb.service.ISpreadsheetContentReader#getCells(org.apache.poi.ss.usermodel.Row)
	 */
	public HashMap<CellAddress, String> getCells(Row row) {
		
		 DataFormatter dataFormatter = new DataFormatter();
		
		HashMap<CellAddress, String> cells = new HashMap<CellAddress, String>();

		 // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                cells.put(cell.getAddress(), cellValue);
            }
		return cells;
	}

	@Override
	public List<String> getWorksheetHeader(Row row) {
		
		DataFormatter dataFormatter = new DataFormatter();
		List<String> worksheetHeader = new ArrayList<String>();
		
		// Now let's iterate over the columns of the current row
        Iterator<Cell> cellIterator = row.cellIterator();
        
		while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String cellValue = dataFormatter.formatCellValue(cell);
            worksheetHeader.add(cellValue);
        }
		return worksheetHeader;
	}

	@Override
	public HashMap<String, String> mapValuesToHeader(List<String> header,
			HashMap<CellAddress, String> row) {
		HashMap<String, String> record = new HashMap<String, String>();
		int i = 0;
		
		// Now let's iterate over the columns of the current row
        Iterator<Entry<CellAddress, String>> cellIterator = row.entrySet().iterator();
        
        while (cellIterator.hasNext()) {
            Map.Entry<CellAddress, String> cell = cellIterator.next();
            record.put(header.get(i), cell.getValue().toString());
            i++;
        }
		
        
        return record;
	}

}
