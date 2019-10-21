/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.projectredcap.main.ImportRecords;

import za.org.wits.sbimb.shipment.Constants.BiospecimenTypes;
import za.org.wits.sbimb.shipment.Constants.ConsentStatus;
import za.org.wits.sbimb.shipment.Constants.Ethnicity;
import za.org.wits.sbimb.shipment.Constants.Gender;
import za.org.wits.sbimb.shipment.Constants.Grade;
import za.org.wits.sbimb.shipment.Constants.Protocol;
import za.org.wits.sbimb.shipment.Constants.Quality;
import za.org.wits.sbimb.shipment.Constants.Status;
import za.org.wits.sbimb.shipment.Constants.StoredIn;
import za.org.wits.sbimb.shipment.Constants.SubjectStatus;
import za.org.wits.sbimb.shipment.Constants.Treatments;
import za.org.wits.sbimb.shipment.Constants.TrueFalseAnswers;
import za.org.wits.sbimb.shipment.Constants.Units;
import za.org.wits.sbimb.shipment.Constants.UploadResponseType;
import za.org.wits.sbimb.shipment.Constants.YesNoAnswers;
import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;
import za.org.wits.sbimb.shipment.model.UploadResponse;

import org.projectredcap.main.Config;


/**
 * @author Freedom Mukomana
 *
 */
public class ConfirmUploadService implements IConfirmUploadService {

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#uploadShipment(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@Override
	public List<UploadResponse> uploadShipment(ShipmentManifest shipmentManifest) {
		
		JSONArray data = null;
		UploadResponse uploadResponse = null;
		List<UploadResponse> uploadResponses = new ArrayList<UploadResponse>();
		
		final Config config = new Config("https://redcap.core.wits.ac.za/redcap/api/", //API URL
				"", //API Token
				"flat", //API CONTENT
				"json", //API FORMAT 
			   "record", //API TYPE
			   "overwrite", //API OVERWRITE BEHAVIOR 
			   "true", //API FORCE AUTO NUMBER
			   "DMY", //API DATE FORMAT 
			   "raw", //API RAW OR LABEL
			   "", //API FIELDS
			   null); //API REPORT ID
		
		config.setAPI_TOKEN("3BD1A2D26FB391313A3CD131E484D142");
				
		data = compileShipmentData(shipmentManifest);
		ImportRecords importRecords = new ImportRecords(config, data);
		importRecords.doPost();
		
		if(importRecords.getRespCode()==200){
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.UNSUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - Shipment details upload successfully");
			uploadResponses.add(uploadResponse);			
		}else{
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.UNSUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - "+importRecords.getResp().getStatusLine().getReasonPhrase());
			uploadResponses.add(uploadResponse);
		}
		
		config.setAPI_TOKEN("302ACE8830AFC93238B75F5E401CE4F5");
		
		data = compileParticipantData(shipmentManifest);
		importRecords = new ImportRecords(config, data);
		importRecords.doPost();		

		if(importRecords.getRespCode()==200){
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.SUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - Participant details upload successfully");
			uploadResponses.add(uploadResponse);
		}else{
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.UNSUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - "+importRecords.getResp().getStatusLine().getReasonPhrase());
			uploadResponses.add(uploadResponse);
		}
		
		config.setAPI_TOKEN("1FA3A1D3D46784622A814A72545AF924");
		
		data = compileBiospecimenData(shipmentManifest);
		importRecords = new ImportRecords(config, data);
		importRecords.doPost();		

		if(importRecords.getRespCode()==200){
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.SUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - Participant details upload successfully");
			uploadResponses.add(uploadResponse);
		}else{
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.UNSUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - "+importRecords.getResp().getStatusLine().getReasonPhrase());
			uploadResponses.add(uploadResponse);
		}
		
		config.setAPI_TOKEN("5695D3FE5F67707A571C90D57BDD0022");
		
		data = compileBiospecimenUploadToJSON(shipmentManifest);
		importRecords = new ImportRecords(config, data);
		importRecords.doPost();		

		if(importRecords.getRespCode()==200){
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.SUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - The ARK upload details upload successfully");
			uploadResponses.add(uploadResponse);
		}else{
			uploadResponse = new UploadResponse();
			uploadResponse.setDataResponseType(UploadResponseType.UNSUCCESSFULL);
			uploadResponse.setMessage(importRecords.getRespCode()+" - "+importRecords.getResp().getStatusLine().getReasonPhrase());
			uploadResponses.add(uploadResponse);
		}
		
		return uploadResponses;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#compileParticipantData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray compileParticipantData(ShipmentManifest shipmentManifest) {
		JSONArray data = new JSONArray();
		
				shipmentManifest.getParticipants().forEach(participant->{
					JSONObject jsonObject = null;
					jsonObject = (JSONObject)convertParticipantToJSON(participant, shipmentManifest.getManifestNumber());
					data.add(jsonObject);
				});
		return data;
	}
	
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#convertToJSON(za.org.wits.sbimb.shipment.model.Participant)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject convertParticipantToJSON(Participant participant, String manifestNumber) {
		JSONObject record = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//record.put("record_id", "");
		record.put("manifest_number", manifestNumber);
		record.put("study_id", participant.getStudyID());
		record.put("status", Integer.toString(SubjectStatus.valueOf(participant.getStatus().toUpperCase()).ordinal()));
		record.put("enrollment_date", dateFormat.format(participant.getEnrollmentDate()));
		record.put("age", Integer.toString(participant.getAge()));
		record.put("other_id", participant.getOtherID());
		record.put("ethnicity", Integer.toString(Ethnicity.valueOf(participant.getEthnicity().toUpperCase()).ordinal()));
		record.put("gender", Integer.toString(Gender.valueOf(participant.getGender().toUpperCase()).ordinal()));
		record.put("comments", participant.getComments());
		record.put("consent_date", dateFormat.format(participant.getConsentDate()));
		record.put("consent_status", Integer.toString(ConsentStatus.valueOf(participant.getConsentStatus().toUpperCase()).ordinal()));
		record.put("data_use", Integer.toString(YesNoAnswers.valueOf(participant.getDataUse().toUpperCase()).ordinal()));
		record.put("biospecimen_use", Integer.toString(YesNoAnswers.valueOf(participant.getBiospecimenUse().toUpperCase()).ordinal()));
		record.put("data_sharing", Integer.toString(YesNoAnswers.valueOf(participant.getDataSharing().toUpperCase()).ordinal()));
		record.put("biospecimen_sharing", Integer.toString(YesNoAnswers.valueOf(participant.getBiospecimenSharing().toUpperCase()).ordinal()));
		record.put("error", TrueFalseAnswers.valueOf(participant.isError().toString().toUpperCase()).ordinal());
		record.put("participant_complete", "2");
		return record;
	}	

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUploadService#linkParticipantToBiospecimen(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@Override
	public void linkParticipantToBiospecimen(ShipmentManifest shipmentManifest) {
		List<Participant> participants = shipmentManifest.getParticipants();
		List<Biospecimen> biospecimens = shipmentManifest.getBiospecimens();
		HashMap<String, Participant> participantMap = new HashMap<String, Participant>();
		
		participants.forEach(participant->{
			participantMap.put(participant.getStudyID(), participant);
		});
		
		biospecimens.forEach(biospecimen->{
			if(participantMap.containsKey(biospecimen.getParticipant().getStudyID()));
		});
		
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#compileBiospecimenData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray compileBiospecimenData(ShipmentManifest shipmentManifest) {
		JSONArray data = new JSONArray();
		
		shipmentManifest.getBiospecimens().forEach(biospecimen->{
			JSONObject jsonObject = null;
			jsonObject = (JSONObject)convertBiospecimenToJSON(biospecimen, shipmentManifest.getManifestNumber());
			data.add(jsonObject);
		});
		
		return data;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#convertToJSON(za.org.wits.sbimb.shipment.model.Biospecimen)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject convertBiospecimenToJSON(Biospecimen biospecimen, String manifestNumber) {
		JSONObject record = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//record.put("record_id", "");
		record.put("manifest_number", manifestNumber);
		record.put("biospecimen_id", biospecimen.getBiospecimenID());
		record.put("study_id", biospecimen.getParticipant().getStudyID());
		record.put("gender", Gender.valueOf(biospecimen.getGender().toUpperCase()).ordinal());
		record.put("collection_date", dateFormat.format(biospecimen.getCollectionDate()));
		record.put("biospecimen_type", biospecimen.getBiospecimenType());
		record.put("plate", biospecimen.getPlate().getName());
		record.put("row", biospecimen.getRow());
		record.put("col", biospecimen.getCol());
		record.put("manual_checked", Boolean.toString(biospecimen.isManualChecked()).toUpperCase());
		record.put("error", Integer.toString(TrueFalseAnswers.valueOf(biospecimen.isError().toString().toUpperCase()).ordinal()));
		record.put("biospecimen_complete", "2");
		return record;
	}
	
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUploadService#complieBiospecimenUploadToJSON(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@Override
	public JSONArray compileBiospecimenUploadToJSON(
			ShipmentManifest shipmentManifest) {
		JSONArray data = new JSONArray();

		shipmentManifest.getBiospecimens().forEach(biospecimen->{
			JSONObject jsonObject = null;
			jsonObject = (JSONObject)convertBiospecimenUploadToJSON(biospecimen, shipmentManifest.getManifestNumber());
			data.add(jsonObject);
		});
		
		return data;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#convertToJSON(za.org.wits.sbimb.shipment.model.Biospecimen)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject convertBiospecimenUploadToJSON(Biospecimen biospecimen, String manifestNumber) {
		JSONObject record = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		record.put("manifest_number", manifestNumber);
		record.put("subjectuid", biospecimen.getParticipant().getStudyID()); //SUBJECTUID
		record.put("biocollectionuid",biospecimen.getParticipant().getStudyID()+"_COL_1"); //BIOCOLLECTIONUID
		record.put("biocollectionname","Collection One"); //BIOCOLLECTIONNAME
		record.put("ageatcollection", biospecimen.getParticipant().getAge()); //AGEATCOLLECTION
		record.put("biocollectioncomments",""); //BIOCOLLECTIONCOMMENTS
		record.put("biocollectiondate", dateFormat.format(biospecimen.getParticipant().getEnrollmentDate())); //BIOCOLLECTIONDATE
		record.put("biospecimenuid", biospecimen.getBiospecimenID()); //BIOSPECIMENUID
		record.put("parentid",""); //PARENTID
		record.put("amountused",""); //AMOUNTUSED
		record.put("biotransaction",""); //BIOTRANSACTION
		record.put("sampletype", Integer.toString(BiospecimenTypes.valueOf(biospecimen.getBiospecimenType()).ordinal())); //SAMPLETYPE
		record.put("biospecimencollectiondate", dateFormat.format(biospecimen.getCollectionDate())); //BIOCOLLECTIONDATE
		record.put("biospecimencollectiontime",""); //BIOCOLLECTIONTIME
		record.put("processdate",""); //PROCESSDATE
		record.put("processtime",""); //PROCESSTIME
		record.put("comments",""); //COMMENTS
		record.put("barcoded",YesNoAnswers.YES.ordinal()); //BARCODED
		record.put("grade",Grade.NA.ordinal()); //GRADE
		record.put("storedin",StoredIn.CRYOVIAL2ML.ordinal()); //STOREDIN
		record.put("anticoagulanttype",""); //ANTICOAGULANTTYPE
		record.put("status",Status.PENDING.ordinal()); //STATUS
		record.put("protocol",Protocol.UNKNOWN.ordinal()); //PROTOCOL
		record.put("purity280",""); //PURITY280
		record.put("purity230",""); //PURITY230
		record.put("quality",Quality.AT.ordinal()); //QUALITY
		record.put("quantity",""); //QUANTITY
		record.put("units",Units.ML.ordinal()); //UNITS
		record.put("treatment",Treatments.AF.ordinal()); //TREATMENT
		record.put("concentration",""); //CONCENTRATION
		record.put("site",""); //SITE
		record.put("freezer",""); //FREEZER
		record.put("shelf",""); //SHELF
		record.put("rack",""); //RACK
		record.put("box", biospecimen.getPlate().getName()); //BOX
		record.put("row", biospecimen.getRow()); //ROW
		record.put("column", biospecimen.getCol()); //COLUMN
		//record.put("manual_checked", Boolean.toString(biospecimen.isManualChecked()).toUpperCase());
		record.put("error", Integer.toString(TrueFalseAnswers.valueOf(biospecimen.isError().toString().toUpperCase()).ordinal()));
		record.put("ark_upload_status", Status.PENDING.ordinal());
		record.put("upload_complete", "2");
				
		return record;
	}


	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#compileShipmentData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray compileShipmentData(ShipmentManifest shipmentManifest) {
		JSONArray data = new JSONArray();
		
		data.add(convertShipmentToJSON(shipmentManifest));
		
		return data;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IConfirmUpload#convertToJSON(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject convertShipmentToJSON(ShipmentManifest shipmentManifest) {
		JSONObject record = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		record.put("manifest_number", shipmentManifest.getManifestNumber());
		record.put("collection_centre", shipmentManifest.getCollectionCentre());
		record.put("reference_number", shipmentManifest.getRefNumber());
		record.put("date_sent", dateFormat.format(shipmentManifest.getDateSent()));
		record.put("number_of_boxes", Integer.toString(shipmentManifest.getNumberOfBoxes()));
		record.put("responsible_person", shipmentManifest.getResponsiblePerson());
		record.put("contact_details", shipmentManifest.getContactDetails());
		record.put("method_of_shipment", shipmentManifest.getMethodOfShipment());
		record.put("number_of_participants", Integer.toString(shipmentManifest.getParticipants().size()));
		record.put("number_of_biospecimen", Integer.toString(shipmentManifest.getBiospecimens().size()));
		//record.put("basic_demography_form_complete", "2");
		return record;
	}
	
	

}
