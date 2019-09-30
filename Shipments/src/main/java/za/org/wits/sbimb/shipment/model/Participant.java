/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import java.util.Date;
import java.util.List;

/**
 * @author Freedom Mukomana
 *
 */
public class Participant {
							
	String studyID; //Study ID
	String status; //Status
	Date enrollmentDate; //Enrollment Date
	Integer age; //Age
	String otherID; //Other ID
	String ethnicity; //Ethnicity
	String gender; //Gender
	String comments; //Comments
	Date consentDate; //Consent Date
	String consentStatus; //Consent Status
	String dataUse; //Data Use
	String biospecimenUse; //Biospecimen Use
	String dataSharing; //Data Sharing
	String biospecimenSharing; //Biospecimen Sharing
	List<Biospecimen> biospecimens;
	/**
	 * @return the studyID
	 */
	public String getStudyID() {
		return studyID;
	}
	/**
	 * @param studyID the studyID to set
	 */
	public void setStudyID(String studyID) {
		this.studyID = studyID;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the enrollmentDate
	 */
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	/**
	 * @param enrollmentDate the enrollmentDate to set
	 */
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the otherID
	 */
	public String getOtherID() {
		return otherID;
	}
	/**
	 * @param otherID the otherID to set
	 */
	public void setOtherID(String otherID) {
		this.otherID = otherID;
	}
	/**
	 * @return the ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}
	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the consentDate
	 */
	public Date getConsentDate() {
		return consentDate;
	}
	/**
	 * @param consentDate the consentDate to set
	 */
	public void setConsentDate(Date consentDate) {
		this.consentDate = consentDate;
	}
	/**
	 * @return the consentStatus
	 */
	public String getConsentStatus() {
		return consentStatus;
	}
	/**
	 * @param consentStatus the consentStatus to set
	 */
	public void setConsentStatus(String consentStatus) {
		this.consentStatus = consentStatus;
	}
	/**
	 * @return the dataUse
	 */
	public String getDataUse() {
		return dataUse;
	}
	/**
	 * @param dataUse the dataUse to set
	 */
	public void setDataUse(String dataUse) {
		this.dataUse = dataUse;
	}
	/**
	 * @return the biospecimenUse
	 */
	public String getBiospecimenUse() {
		return biospecimenUse;
	}
	/**
	 * @param biospecimenUse the biospecimenUse to set
	 */
	public void setBiospecimenUse(String biospecimenUse) {
		this.biospecimenUse = biospecimenUse;
	}
	/**
	 * @return the dataSharing
	 */
	public String getDataSharing() {
		return dataSharing;
	}
	/**
	 * @param dataSharing the dataSharing to set
	 */
	public void setDataSharing(String dataSharing) {
		this.dataSharing = dataSharing;
	}
	/**
	 * @return the biospecimenSharing
	 */
	public String getBiospecimenSharing() {
		return biospecimenSharing;
	}
	/**
	 * @param biospecimenSharing the biospecimenSharing to set
	 */
	public void setBiospecimenSharing(String biospecimenSharing) {
		this.biospecimenSharing = biospecimenSharing;
	}
	/**
	 * @return the biospecimens
	 */
	public List<Biospecimen> getBiospecimens() {
		return biospecimens;
	}
	/**
	 * @param biospecimens the biospecimens to set
	 */
	public void setBiospecimens(List<Biospecimen> biospecimens) {
		this.biospecimens = biospecimens;
	}
}
