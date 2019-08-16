/**
 * 
 */
package za.org.wits.sbimb.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;

/**
 * @author Freedom Mukomana
 *
 */
public interface ISpreadsheetContentReader {
	public Workbook getWorkBook(File file) throws EncryptedDocumentException, InvalidFormatException, IOException;
	public HashMap<String, Sheet> getWorksheets(Workbook workbook);
	public List<Row> getRows(Sheet sheet);
	public HashMap<CellAddress, String> getCells(Row row);
	public List<String> getWorksheetHeader(Row row);
	public HashMap<String, String> mapValuesToHeader(List<String> header, HashMap<CellAddress, String> row);
}
