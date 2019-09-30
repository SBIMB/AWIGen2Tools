/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import za.org.wits.sbimb.shipment.Constants.BiospecimenTypes;
import za.org.wits.sbimb.shipment.Constants.CollectionCentres;
import za.org.wits.sbimb.shipment.Constants.ConsentAnswers;
import za.org.wits.sbimb.shipment.Constants.DataErrorType;
import za.org.wits.sbimb.shipment.Constants.Ethnicity;
import za.org.wits.sbimb.shipment.Constants.Gender;
import za.org.wits.sbimb.shipment.Constants.SubjectStatus;
import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.DataError;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public class DataValidationService implements IDataValidationService {

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IDataValidationService#checkDataErrors(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@Override
	public List<DataError> checkDataErrors(ShipmentManifest shipmentManifest) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IDataValidationService#checkManifestErrors(za.org.wits.sbimb.shipment.model.ShipmentManifest)
	 */
	@Override
	public List<DataError> checkManifestErrors(ShipmentManifest shipmentManifest) {
		List<DataError> dataErrors = new ArrayList<DataError>();
		
		if(shipmentManifest.getManifestNumber()==null || shipmentManifest.getManifestNumber().isEmpty()){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Shipping Manifest number is missing");
			dataErrors.add(dataError);
		}
		
		if(shipmentManifest.getRefNumber()==null || shipmentManifest.getRefNumber().isEmpty()){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Waybill or reference number is missing");
			dataErrors.add(dataError);
		}
		
		if(shipmentManifest.getCollectionCentre()==null || shipmentManifest.getCollectionCentre().isEmpty()){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Collection centre name is missing");
			dataErrors.add(dataError);
		}else if(!CollectionCentres.contains(shipmentManifest.getCollectionCentre())){
			DataError dataError = new DataError();
				
			dataError.setDataErrorType(DataErrorType.INCORRECT);
			dataError.setMessage("Collection centre name is incorrect");			
		}
		
		if(shipmentManifest.getResponsiblePerson()==null || shipmentManifest.getResponsiblePerson().isEmpty()){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Name of the responsible person is missing");
			dataErrors.add(dataError);
		}
		
		if(shipmentManifest.getDateSent()==null){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Date sent is missing");
			dataErrors.add(dataError);
		}else if(shipmentManifest.getDateSent().before(new Date())){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Date sent has to be in the past");
			dataErrors.add(dataError);
		}
		
		if(shipmentManifest.getContactDetails()==null || shipmentManifest.getContactDetails().isEmpty()){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Name of the responsible person is missing");
			dataErrors.add(dataError);
		}
		
		if(shipmentManifest.getNumberOfBoxes()==null){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("Name of the responsible person is missing");
			dataErrors.add(dataError);
		}else if(shipmentManifest.getNumberOfBoxes()<1){
			DataError dataError = new DataError();
			
			dataError.setDataErrorType(DataErrorType.MISSING);
			dataError.setMessage("The number of boxes cannot be less than 1");
			dataErrors.add(dataError);
		}
		
		shipmentManifest.getParticipants().forEach(participant->{
			List<DataError> participantDataErrors = new ArrayList<DataError>();
			participantDataErrors = checkParticipantErrors(participant);
			dataErrors.addAll(participantDataErrors);
		});
		
		shipmentManifest.getBiospecimens().forEach(biospecimen->{
			List<DataError> biospecimenDataErrors = new ArrayList<DataError>();
			biospecimenDataErrors = checkBiospecimenErrors(biospecimen);
			dataErrors.addAll(biospecimenDataErrors);			
		});
		
		return dataErrors;
	}
	
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IDataValidationService#checkParticipantErrors(za.org.wits.sbimb.shipment.model.Participant)
	 */
	@Override
	public List<DataError> checkParticipantErrors(Participant participant) {
		List<DataError> participantDataErrors = new ArrayList<DataError>();
		
		if(participant.getStudyID()==null || participant.getStudyID().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID is missing");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getStatus()==null || participant.getStatus().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Participant status is missing");
			participantDataErrors.add(participantDataError);
		}else if(!SubjectStatus.contains(participant.getStatus())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Participant status is incorrect refer to instructions in the manifest");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getEnrollmentDate()==null){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Name of the responsible person is missing");
			participantDataErrors.add(participantDataError);
		}else if(participant.getEnrollmentDate().before(new Date())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Enrollment date has to be in the past");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getAge()==null){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Age is missing");
			participantDataErrors.add(participantDataError);
		}else if(participant.getAge()<1){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Participant's age cannot be less than 1");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getEthnicity()==null || participant.getEthnicity().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Ethnicty is missing");
			participantDataErrors.add(participantDataError);
		}else if(!Ethnicity.contains(participant.getStatus())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Ethnicity is incorrect refer to instructions in the manifest");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getGender()==null || participant.getGender().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Gender is missing");
			participantDataErrors.add(participantDataError);
		}else if(!Gender.contains(participant.getGender())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Gender is incorrect. Use one of the following options"+Gender.getValues());
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getConsentDate()==null){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Consent date is missing");
			participantDataErrors.add(participantDataError);
		}else if(participant.getEnrollmentDate().before(new Date())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Consent date has to be in the past");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getDataUse()==null || participant.getDataUse().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Data use is missing");
			participantDataErrors.add(participantDataError);
		}else if(!ConsentAnswers.contains(participant.getDataUse())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Data use is incorrect refer to instructions in the manifest");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getBiospecimenUse()==null || participant.getBiospecimenUse().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Biospecimen use is missing");
			participantDataErrors.add(participantDataError);
		}else if(!ConsentAnswers.contains(participant.getBiospecimenUse())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Biospecimen use is incorrect refer to instructions in the manifest");
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getDataSharing()==null || participant.getDataSharing().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Data sharing is missing");
			participantDataErrors.add(participantDataError);
		}else if(!ConsentAnswers.contains(participant.getDataSharing())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Data sharing is incorrect. Use one of the following options"+ConsentAnswers.getValues());
			participantDataErrors.add(participantDataError);
		}
		
		if(participant.getBiospecimenSharing()==null || participant.getBiospecimenSharing().isEmpty()){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.MISSING);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Biospecimen sharing is missing");
			participantDataErrors.add(participantDataError);
		}else if(!ConsentAnswers.contains(participant.getBiospecimenSharing())){
			DataError participantDataError = new DataError();
			
			participantDataError.setDataErrorType(DataErrorType.INCORRECT);
			participantDataError.setMessage("Study ID "+participant.getStudyID()+" - Biospecimen sharing is incorrect. Use one of the following options"+ConsentAnswers.getValues());
			participantDataErrors.add(participantDataError);
		}
		
		return participantDataErrors;
	}
	
	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IDataValidationService#checkBiospecimenErrors(za.org.wits.sbimb.shipment.model.Biospecimen)
	 */
	@Override
	public List<DataError> checkBiospecimenErrors(Biospecimen biospecimen) {
		List<DataError> biospecimenDataErrors = new ArrayList<DataError>();
		
		if(biospecimen.getStudyID()==null || biospecimen.getStudyID().isEmpty()){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage("Study ID is missing");
			biospecimenDataErrors.add(biospecimenDataError);
		}
		
		if(biospecimen.getGender()==null || biospecimen.getGender().isEmpty()){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage("Study ID "+biospecimen.getStudyID()+" Biospecimen ID "+biospecimen.getBiospecimenID()+" - Gender is missing");
			biospecimenDataErrors.add(biospecimenDataError);
		}else if(!Gender.contains(biospecimen.getGender())){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.INCORRECT);
			biospecimenDataError.setMessage("Study ID "+biospecimen.getStudyID()+" Biospecimen ID "+biospecimen.getBiospecimenID()+" - Gender is incorrect. Use one of the following options"+Gender.getValues());
			biospecimenDataErrors.add(biospecimenDataError);
		}
		
		if(biospecimen.getBiospecimenID()==null || biospecimen.getBiospecimenID().isEmpty()){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage(biospecimen.getStudyID()+"(Study ID) : "+biospecimen.getBiospecimenID()+"(Biospecimen ID) - Biospecimen ID is missing");
			biospecimenDataErrors.add(biospecimenDataError);
		}
		
		if(biospecimen.getCollectionDate()==null){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage(biospecimen.getStudyID()+"(Study ID) : "+biospecimen.getBiospecimenID()+"(Biospecimen ID) -  Name of the responsible person is missing");
			biospecimenDataErrors.add(biospecimenDataError);
		}else if(biospecimen.getCollectionDate().before(new Date())){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage(biospecimen.getStudyID()+"(Study ID) : "+biospecimen.getBiospecimenID()+"(Biospecimen ID) - Enrollment date has to be in the past");
			biospecimenDataErrors.add(biospecimenDataError);
		}
		
		if(biospecimen.getBiospecimenType()==null || biospecimen.getBiospecimenType().isEmpty()){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.MISSING);
			biospecimenDataError.setMessage(biospecimen.getStudyID()+"(Study ID) : "+biospecimen.getBiospecimenID()+"(Biospecimen ID) - Biospecimen type is missing");
			biospecimenDataErrors.add(biospecimenDataError);
		}else if(!BiospecimenTypes.contains(biospecimen.getBiospecimenType())){
			DataError biospecimenDataError = new DataError();
			
			biospecimenDataError.setDataErrorType(DataErrorType.INCORRECT);
			biospecimenDataError.setMessage(biospecimen.getStudyID()+"(Study ID) : "+biospecimen.getBiospecimenID()+"(Biospecimen ID) - Biospecimen type is incorrect. Use one of the following options "+BiospecimenTypes.getValues());
			biospecimenDataErrors.add(biospecimenDataError);
		}
		
		return biospecimenDataErrors;
	}

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.shipment.service.IDataValidationService#checkDataMissingness()
	 */
	@Override
	public List<DataError> checkDataMissingness() {
		// TODO Auto-generated method stub
		return null;
	}

}
