/**
 * 
 */
package za.org.wits.sbimb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;

import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public class ImportFromSpreadsheet implements IImportFromSpreadsheet {
	
	ISpreadsheetContentReader spreadsheetContentReader = new SpreadsheetContentReader();

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.IImportFromSpreadsheet#convert(org.apache.poi.ss.usermodel.Workbook)
	 */
	public ShipmentManifest convert(Workbook workbook) {
		
		HashMap<String, Sheet> worksheets = spreadsheetContentReader.getWorksheets(workbook);
		Iterator<Entry<String, Sheet>> it = worksheets.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<String, Sheet> entry = it.next();
			String worksheetName = entry.getKey().toLowerCase();
			Sheet worksheet = entry.getValue();
	
			switch(worksheetName){
				case "Container Report and Sample Man" :
					//Get worksheet rows
					List<Row> shipmentManifestRows = spreadsheetContentReader.getRows(worksheet);
					HashMap <CellAddress, String> shipmentManifestCells = new HashMap<>();
					
					for(Row row : shipmentManifestRows){
						HashMap <CellAddress, String> cells = spreadsheetContentReader.getCells(row);
						shipmentManifestCells.putAll(cells);
					}
					
					ShipmentManifest shipmentManifest = new ShipmentManifest();
					shipmentManifest.setManifestNumber(shipmentManifestCells.get("E4"));
					shipmentManifest.setCollectionCentre(shipmentManifestCells.get("M4"));
					shipmentManifest.setRefNumber(shipmentManifestCells.get("E6"));
					shipmentManifest.setResponsiblePerson(shipmentManifestCells.get("M6"));
					try {
						shipmentManifest.setDateSent(new SimpleDateFormat("DD/MM/YYYY").parse(shipmentManifestCells.get("E8")));
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					shipmentManifest.setContactDetails(shipmentManifestCells.get("M8"));
					shipmentManifest.setMethodOfShipment(shipmentManifestCells.get("M8"));
				case "Plate Template (10X10)":
					
				case "Plate Template (9X9)":
				
				case "Plate Template (12X8)":
					
				case "Instructions":
					
				case "Participants" :
					
					HashMap<String, Participant> participants = new HashMap<String, Participant>();
					
					//Get worksheet rows
					List<Row> participantsRows = spreadsheetContentReader.getRows(worksheet);
									
					//Get the first row and remove the header row from the list of rows
					List<String> worksheetHeader = spreadsheetContentReader.getWorksheetHeader(participantsRows.get(0));
					participantsRows.remove(0);
					
					//Extract data from the rest of the rows 
					for(Row row : participantsRows){
						Participant participant = new Participant();
						
						HashMap <CellAddress, String> cells = spreadsheetContentReader.getCells(row);
						
						HashMap<String, String> mappedCells = spreadsheetContentReader.mapValuesToHeader(worksheetHeader, cells);
						//No									Consent Date					
						//Study ID
						participant.setStudyID(mappedCells.get("Study ID"));
						
						//Status
						participant.setStatus(mappedCells.get("status"));
						
						//Enrollment Date
						try {
							participant.setEnrollmentDate(new SimpleDateFormat("DD/MM/YYYY").parse(mappedCells.get("enrollmentDate")));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//Age
						participant.setAge(Integer.parseInt(mappedCells.get("age")));
						
						//Other ID
						participant.setOtherID(mappedCells.get("otherID"));
						
						//Ethnicity
						participant.setEthnicity(mappedCells.get("ethnicity"));
						
						//Gender
						participant.setGender(mappedCells.get("Gender"));
						
						//Comments
						participant.setComments(mappedCells.get("comments"));
						
						//Consent Date
						try {
							participant.setConsentDate(new SimpleDateFormat("DD/MM/YYYY").parse(mappedCells.get("Consent Date")));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						//Consent Status
						participant.setConsentStatus(mappedCells.get("Consent Status"));
														
						//Data Use
						participant.setDataUse(mappedCells.get("Data Use"));
						
						//Biospecimen Use
						participant.setBiospecimenUse(mappedCells.get("Biospecimen Use"));	
						
						//Data Sharing
						participant.setDataSharing(mappedCells.get("Data Sharing"));
						
						//Biospecimen Sharing
						participant.setBiospecimenSharing(mappedCells.get("Biospecimen Sharing"));
						participants.put(participant.getStudyID(), participant);
					}
					
					break;
				default:
					
					HashMap<String, Biospecimen> biospecimens = new HashMap<String, Biospecimen>();
					
					//Get worksheet rows
					List<Row> biospecimenRows = spreadsheetContentReader.getRows(worksheet);
									
					//Get the first row and remove the header row from the list of rows
					List<String> bioWorksheetHeader = spreadsheetContentReader.getWorksheetHeader(biospecimenRows.get(0));
					biospecimenRows.remove(0);
					
					//Extract data from the rest of the rows 
					for(Row row : biospecimenRows){
						Biospecimen biospecimen = new Biospecimen();
						
						HashMap <CellAddress, String> cells = spreadsheetContentReader.getCells(row);
						
						HashMap<String, String> mappedCells = spreadsheetContentReader.mapValuesToHeader(bioWorksheetHeader, cells);
						
						biospecimen.setStudyID(mappedCells.get("Study ID"));	
						biospecimen.setGender(mappedCells.get("Gender"));
						biospecimen.setBiospecimenID(mappedCells.get("Biospecimen ID"));
						try {
							biospecimen.setCollectionDate(new SimpleDateFormat("DD/MM/YYYY").parse(mappedCells.get("Collection Date")));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						biospecimen.setBiospecimenType(mappedCells.get("Biospecimen Type"));	
						biospecimen.setCol(Integer.parseInt(mappedCells.get("Column")));	
						biospecimen.setRow(Integer.parseInt(mappedCells.get("Row")));
						biospecimen.setIsManualChecked(Boolean.parseBoolean(mappedCells.get("Manual Check")));
						biospecimens.put(biospecimen.getBiospecimenID(), biospecimen);
					}				
			}	
		}
		return null;
	}

}
