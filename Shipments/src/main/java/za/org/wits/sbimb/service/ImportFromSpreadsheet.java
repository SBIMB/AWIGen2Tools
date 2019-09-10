/**
 * 
 */
package za.org.wits.sbimb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.cellwalk.CellHandler;

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
		ShipmentManifest shipmentManifest = new ShipmentManifest();
		List<String> configAddresses = new ArrayList<String>(Arrays.asList("E4","E6","E8","E10","M4","M6","M8","M10"));
		List<String> configTitles = new ArrayList<String>(Arrays.asList("E4","E6","E8","E10","M4","M6","M8","M10"));
		while(it.hasNext()){
			Entry<String, Sheet> entry = it.next();
			String worksheetName = entry.getKey().toLowerCase();
			Sheet worksheet = entry.getValue();
	
			switch(worksheetName.toLowerCase().trim()){
				case "container report and sample man" :
					//Get worksheet rows
					List<Row> shipmentManifestRows = spreadsheetContentReader.getRows(worksheet);
					HashMap <String, String> shipmentManifestCells = new HashMap<>();
					
					for(Row row : shipmentManifestRows){
						HashMap <String, String> cells = spreadsheetContentReader.getCells(workbook, configAddresses, configTitles, row);
						shipmentManifestCells.putAll(cells);
					}					
					
					shipmentManifest.setManifestNumber(shipmentManifestCells.get("E4"));
					shipmentManifest.setCollectionCentre(shipmentManifestCells.get("M4"));
					shipmentManifest.setRefNumber(shipmentManifestCells.get("E6"));
					shipmentManifest.setResponsiblePerson(shipmentManifestCells.get("M6"));
					try {
						String enrollmenDateStr = shipmentManifestCells.get("E8");
						if(enrollmenDateStr!=null && enrollmenDateStr.equalsIgnoreCase("") && !enrollmenDateStr.isEmpty())
							shipmentManifest.setDateSent(new SimpleDateFormat("DD/MM/YYYY").parse(shipmentManifestCells.get("M8")));
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					shipmentManifest.setContactDetails(shipmentManifestCells.get("E8"));
					shipmentManifest.setMethodOfShipment(shipmentManifestCells.get("M8"));
					break;
				case "plate template (10x10)":
					
				case "plate template (9x9)":
				
				case "plate template (12x8)":
					
				case "instructions":
					break;
				case "participants" :
					
					HashMap<String, Participant> participants = new HashMap<String, Participant>();
					
					List<Participant> participants2 = new ArrayList<Participant>();
					
					//Get worksheet rows
					List<Row> participantsRows = spreadsheetContentReader.getRows(worksheet);
									
					//Get the first row and remove the header row from the list of rows
					HashMap<CellAddress, String> worksheetHeader = spreadsheetContentReader.getWorksheetHeader(participantsRows.get(0));
					participantsRows.remove(0);
					
					//Extract data from the rest of the rows 
					for(Row row : participantsRows){
						Participant participant = new Participant();
						
						HashMap <String, String> cells = spreadsheetContentReader.getCells(workbook, worksheetHeader, row);
						
						HashMap<String, String> mappedCells = spreadsheetContentReader.mapValuesToHeader(worksheetHeader, new HashMap<CellAddress, String>());
						//No									Consent Date					
						//Study ID
						participant.setStudyID(cells.get("Study ID"));
						
						//Status
						participant.setStatus(cells.get("Status"));
						
						//Enrollment Date
						try {
							String enrollmenDateStr = cells.get("Collection Date");
							if(enrollmenDateStr!=null && enrollmenDateStr.equalsIgnoreCase("") && !enrollmenDateStr.isEmpty())
								participant.setEnrollmentDate(new SimpleDateFormat("DD/MM/YYYY").parse(cells.get("enrollmentDate")));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//Age
						String ageStr = cells.get("Age");
						if(ageStr!=null && ageStr.equalsIgnoreCase("") && !ageStr.isEmpty())
							participant.setAge(Integer.parseInt(cells.get("Age")));
						
						//Other ID
						participant.setOtherID(cells.get("Other ID"));
						
						//Ethnicity
						participant.setEthnicity(cells.get("Ethnicity"));
						
						//Gender
						participant.setGender(cells.get("Gender"));
						
						//Comments
						participant.setComments(cells.get("Comments"));
						
						//Consent Date
						try {
							String consentDateStr = cells.get("Collection Date");
							if(consentDateStr!=null && consentDateStr.equalsIgnoreCase("") && !consentDateStr.isEmpty())
								participant.setConsentDate(new SimpleDateFormat("DD/MM/YYYY").parse(cells.get("Consent Date")));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						//Consent Status
						participant.setConsentStatus(cells.get("Consent Status"));
														
						//Data Use
						participant.setDataUse(cells.get("Data Use"));
						
						//Biospecimen Use
						participant.setBiospecimenUse(cells.get("Biospecimen Use"));	
						
						//Data Sharing
						participant.setDataSharing(cells.get("Data Sharing"));
						
						//Biospecimen Sharing
						participant.setBiospecimenSharing(cells.get("Biospecimen Sharing"));
						participants.put(participant.getStudyID(), participant);
						
						participants2.add(participant);						
					}
					
					shipmentManifest.setParticipants(participants2);					
					break;
				default:
					
					HashMap<String, Biospecimen> biospecimens = new HashMap<String, Biospecimen>();
					List<Biospecimen> biospecimens2 = new ArrayList<Biospecimen>();
					
					//Get worksheet rows
					List<Row> biospecimenRows = spreadsheetContentReader.getRows(worksheet);
									
					//Get the first row and remove the header row from the list of rows
					HashMap<CellAddress, String> bioWorksheetHeader = spreadsheetContentReader.getWorksheetHeader(biospecimenRows.get(0));
					biospecimenRows.remove(0);
					
					//Extract data from the rest of the rows 
					for(Row row : biospecimenRows){
						Biospecimen biospecimen = new Biospecimen();
						
						HashMap <String, String> cells = spreadsheetContentReader.getCells(workbook, bioWorksheetHeader, row);
						
						HashMap<String, String> mappedCells = spreadsheetContentReader.mapValuesToHeader(bioWorksheetHeader, new HashMap<CellAddress, String>());
						
						biospecimen.setStudyID(cells.get("Study ID"));	
						biospecimen.setGender(cells.get("Gender"));
						biospecimen.setBiospecimenID(cells.get("Biospecimen ID"));
						try {
							//System.out.println(cells.get("Study ID"));
							String collectionDateStr = cells.get("Collection Date");
							if(collectionDateStr!=null && collectionDateStr.equalsIgnoreCase("") && !collectionDateStr.isEmpty())
								biospecimen.setCollectionDate(new SimpleDateFormat("DD/MM/YYYY").parse(collectionDateStr));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						biospecimen.setBiospecimenType(cells.get("Biospecimen Type"));	
																
						String columnStr = cells.get("Column");
						if(columnStr!=null &&columnStr.equalsIgnoreCase("") && !columnStr.isEmpty())
							biospecimen.setCol(Integer.parseInt(cells.get("Column")));	
						
						String rowStr = cells.get("Row");
						if(rowStr!=null && rowStr.equalsIgnoreCase("") && !rowStr.isEmpty())
							biospecimen.setRow(Integer.parseInt(cells.get("Row")));
						
						String manualCheckedStr = cells.get("Manual Check");
						if(manualCheckedStr!=null && manualCheckedStr.equalsIgnoreCase("") && !manualCheckedStr.isEmpty())
							biospecimen.setIsManualChecked(Boolean.parseBoolean(cells.get("Manual Check")));
						
						biospecimens.put(biospecimen.getBiospecimenID(), biospecimen);
						biospecimens2.add(biospecimen);
					}
					
					
			}	
		}
		return shipmentManifest;
	}

}
