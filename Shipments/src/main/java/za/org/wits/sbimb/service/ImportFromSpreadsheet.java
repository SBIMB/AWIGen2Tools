/**
 * 
 */
package za.org.wits.sbimb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.Plate;
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
		HashMap<String, Participant> participants = null;
		Iterator<Entry<String, Sheet>> it = worksheets.entrySet().iterator();
		ShipmentManifest shipmentManifest = new ShipmentManifest();
		List<String> configAddresses = new ArrayList<String>(Arrays.asList("E4","E6","E8","E10","M4","M6","M8","M10"));
		List<String> configTitles = new ArrayList<String>(Arrays.asList("Manifest Number","Reference Number","Date Sent","Number Of Boxes","Collection Centre","Responsible Person","Contact Details","Method Of Shipment"));
		
		//Get Manifest details
		
		worksheets.forEach((key, value)->{
			System.out.println(key);
		});
		
		Sheet worksheet = worksheets.get("CONTAINER REPORT AND SAMPLE MAN");
		
		System.out.println(worksheet.getSheetName());
		//Get worksheet rows
		List<Row> shipmentManifestRows = spreadsheetContentReader.getRows(worksheet);
		HashMap <String, String> shipmentManifestCells = new HashMap<>();
		
		for(Row row : shipmentManifestRows){
			HashMap <String, String> cells = spreadsheetContentReader.getCells(workbook, configAddresses, configTitles, row);
			shipmentManifestCells.putAll(cells);
		}					
		
		if(shipmentManifestCells.get("E4")!=null)
			shipmentManifest.setManifestNumber(shipmentManifestCells.get("E4"));
		
		if(shipmentManifestCells.get("M4")!=null)
			shipmentManifest.setCollectionCentre(shipmentManifestCells.get("M4"));
		
		if(shipmentManifestCells.get("E6")!=null)
			shipmentManifest.setRefNumber(shipmentManifestCells.get("E6"));
		
		if(shipmentManifestCells.get("M6")!=null)
			shipmentManifest.setResponsiblePerson(shipmentManifestCells.get("M6"));
		
		if(shipmentManifestCells.get("E8")!=null){
			try {
				String sendDateStr = shipmentManifestCells.get("E8");
				if(sendDateStr!=null && !sendDateStr.equalsIgnoreCase("") && !sendDateStr.isEmpty()){
					Date sendDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(sendDateStr);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					shipmentManifest.setDateSent(new SimpleDateFormat("dd-MM-yyyy").parse(sdf.format(sendDate)));
				}
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		
		if(shipmentManifestCells.get("M8")!=null)
			shipmentManifest.setContactDetails(shipmentManifestCells.get("M8"));
		
		if(shipmentManifestCells.get("E10")!=null){
			if(isDouble(shipmentManifestCells.get("E10")))
					shipmentManifest.setNumberOfBoxes((int)Double.parseDouble(shipmentManifestCells.get("E10")));
			if(isInteger(shipmentManifestCells.get("E10")))
				shipmentManifest.setNumberOfBoxes(Integer.parseInt(shipmentManifestCells.get("E10")));
		}
		
		if(shipmentManifestCells.get("M10")!=null)
			shipmentManifest.setMethodOfShipment(shipmentManifestCells.get("M10"));
		
		//Get Participant data
		worksheet = worksheets.get("PARTICIPANTS");
		participants = new HashMap<String, Participant>();
		
		List<Participant> participants2 = new ArrayList<Participant>();
		
		//Get worksheet rows
		List<Row> participantsRows = spreadsheetContentReader.getRows(worksheet);
		
		//Get the first row and remove the header row from the list of rows
		participantsRows.remove(0);					
		
		//Extract data from the rest of the rows 
		for(Row row : participantsRows){
			Participant participant = new Participant();						
			
			List<String> rowList = spreadsheetContentReader.getRowAsList(row);			
			
			if(row.getRowNum()>101 || ((rowList.get(1).equals(null) || rowList.get(1).isEmpty() || rowList.get(1).equalsIgnoreCase("")))){
				
			}else{											
				//Study ID
				if(rowList.get(1)!=null || !rowList.get(1).isEmpty())
					participant.setStudyID(rowList.get(1));
				
				//Status
				if(rowList.get(2)!=null || !rowList.get(2).isEmpty())
					participant.setStatus(rowList.get(2));
				
				//Enrollment Date
				try {
					String enrollmentDateStr = rowList.get(3);
					if(enrollmentDateStr!=null && !enrollmentDateStr.equalsIgnoreCase("") && !enrollmentDateStr.isEmpty()){
						Date enrollmentDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(enrollmentDateStr);
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						participant.setEnrollmentDate(new SimpleDateFormat("dd-MM-yyyy").parse(sdf.format(enrollmentDate)));
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Age
				String ageStr = rowList.get(4);
				if(ageStr!=null && !ageStr.equalsIgnoreCase("") && !ageStr.isEmpty())
					participant.setAge((int)Double.parseDouble(ageStr));
				
				//Other ID
				participant.setOtherID(rowList.get(5));
				
				//Ethnicity
				participant.setEthnicity(rowList.get(6));
				
				//Gender
				participant.setGender(rowList.get(7));
				
				//Comments
				participant.setComments(rowList.get(8));
				
				
				//Consent Date
				try {
					String consentDateStr = rowList.get(9);							
					if(consentDateStr!=null && !consentDateStr.equalsIgnoreCase("") && !consentDateStr.isEmpty()){
						Date consentDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(consentDateStr);
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						participant.setConsentDate(new SimpleDateFormat("dd-MM-yyyy").parse(sdf.format(consentDate)));}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//Consent Status
				participant.setConsentStatus(rowList.get(10));
												
				//Data Use
				participant.setDataUse(rowList.get(11));
				
				//Biospecimen Use
				participant.setBiospecimenUse(rowList.get(12));	
				
				//Data Sharing
				participant.setDataSharing(rowList.get(13));
				
				//Biospecimen Sharing
				participant.setBiospecimenSharing(rowList.get(14));
				
				if(!participant.getStudyID().equals(null) && !participant.getStudyID().isEmpty()){
					participants.put(participant.getStudyID(), participant);
					participants2.add(participant);		
				}
			}
		}
								
		shipmentManifest.setParticipants(participants2);		
		
		worksheets.forEach((sheetName, sheet)->{
			System.out.println(sheetName);
		});
		
		while(it.hasNext()){
			Entry<String, Sheet> entry = it.next();
			String worksheetName = entry.getKey().toUpperCase();
			worksheet = entry.getValue();
			
			
	
			switch(worksheetName.toUpperCase().trim()){
				case "CONTAINER REPORT AND SAMPLE MAN" :
					
				case "PLATE TEMPLATE (14X14)":
					
				case "PLATE TEMPLATE (10X10)":
					
				case "PLATE TEMPLATE (9X9)":
				
				case "PLATE TEMPLATE (12X8)":
					
				case "INSTRUCTIONS":
					
				case "PARTICIPANTS" :
					break;					
				default:
					
					HashMap<String, Biospecimen> biospecimens = new HashMap<String, Biospecimen>();
					List<Biospecimen> biospecimens2 = new ArrayList<Biospecimen>();
					
					//Get worksheet rows
					List<Row> biospecimenRows = spreadsheetContentReader.getRows(worksheet);
					
					//Get the first row and remove the header row from the list of rows
					biospecimenRows.remove(0);
					
					Plate plate = new Plate();
					plate.setName(worksheet.getSheetName());					
										
					//Extract data from the rest of the rows 
					for(Row row : biospecimenRows){
						Biospecimen biospecimen = new Biospecimen();
						
						List<String> rowList = spreadsheetContentReader.getRowAsList(row);
						
						if(row.getRowNum()>101 || ((rowList.get(1).equals(null) || rowList.get(1).isEmpty() || rowList.get(1).equalsIgnoreCase("")) || (rowList.get(3).equals(null) || rowList.get(3).isEmpty() || rowList.get(3).equalsIgnoreCase("")))){
							System.out.println("Broken");
							break;
						}else{
							
							//Study ID
							if(rowList.get(1)!=null || !rowList.get(1).isEmpty()){
								String studyID = rowList.get(1);
								if(participants!=null){
									Participant participant = participants.get(studyID);
									biospecimen.setParticipant(participant);
								}else{
									System.out.println("No participants");
								}							
							}
							
							//Gender
							if(rowList.get(2)!=null || !rowList.get(2).isEmpty())
								biospecimen.setGender(rowList.get(2));
							
							//Biospecimen ID
							if(rowList.get(3)!=null || !rowList.get(3).isEmpty())
								biospecimen.setBiospecimenID(rowList.get(3));
							System.out.println("Study ID: "+biospecimen.getParticipant().getStudyID()+", Biospecimen ID: "+biospecimen.getBiospecimenID());
							//Colleection Date
							try {
								String collectionDateStr = rowList.get(4);
								if(collectionDateStr!=null && !collectionDateStr.equalsIgnoreCase("") && !collectionDateStr.isEmpty()){
									Date collectionDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(collectionDateStr);
									SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
									biospecimen.setCollectionDate(new SimpleDateFormat("dd-MM-yyyy").parse(sdf.format(collectionDate)));
								}
							} catch (ParseException e) {
								e.printStackTrace();
							}
							
							//Biospecimen Type
							if(rowList.get(5)!=null || !rowList.get(5).isEmpty())
								biospecimen.setBiospecimenType(rowList.get(5));
	
							//Biospecimen Plate
							biospecimen.setPlate(plate);
							
							//Column
							String colStr = rowList.get(6);
							if(colStr!=null && !colStr.equalsIgnoreCase("") && !colStr.isEmpty()){
								if(Character.isDigit(colStr.charAt(0))){
									biospecimen.setCol(colStr.toString());
								}else{
									if(colStr.contains(".")){
										biospecimen.setCol(Integer.toString((int)Double.parseDouble(colStr)));
									}else{
										biospecimen.setCol(String.valueOf(colStr));
									}
								}
							}							
							
							//Row
							String rowStr = rowList.get(7);
							if(rowStr!=null && !rowStr.equalsIgnoreCase("") && !rowStr.isEmpty()){
								if(rowStr.contains(".")){
									biospecimen.setRow(Integer.toString((int)Double.parseDouble(rowStr)));
								}else{
									biospecimen.setRow(rowStr.toString());
								}
								
							}							
							
							//Manual Check
							String manualChecked = null;
							if(rowList.get(8)!=null || !rowList.get(8).isEmpty()){
								manualChecked = rowList.get(8);
								biospecimen.setManualChecked(Boolean.valueOf(manualChecked));						
							}
							
							if(biospecimen.getParticipant().getStudyID()!=null && !biospecimen.getParticipant().getStudyID().isEmpty() && biospecimen.getBiospecimenID()!=null && !biospecimen.getBiospecimenID().isEmpty()){	
								biospecimens.put(biospecimen.getBiospecimenID(), biospecimen);
								biospecimens2.add(biospecimen);						
							}
						}
					}
					plate.setBiospecimens(biospecimens2);					
					shipmentManifest.setBiospecimens(biospecimens2);
				}								
			}
				
		return shipmentManifest;
	}
	
	 public static boolean isInteger(String s) {
		 try {
			 	Integer.parseInt(s);
			 } catch(NumberFormatException e) {
				 return false; 
	        }
	        
		 // only got here if we didn't return false
		 return true;
	}
	 
	 public static boolean isDouble(String str) {
		    try {
		        Double.parseDouble(str);
		    } catch (NumberFormatException nfe) {
		    	return false;
		    }
		    return true;
	}
}
