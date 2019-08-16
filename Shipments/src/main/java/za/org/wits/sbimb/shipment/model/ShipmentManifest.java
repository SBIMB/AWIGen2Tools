/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import java.util.Date;

/**
 * @author Freedom Mukomana
 *
 */
public class ShipmentManifest {
	String manifestNumber;
	String collectionCentre;
	String refNumber ;
	Date dateSent;
	Integer numberOfBoxes;
	String responsiblePerson;
	String contactDetails;
	String methodOfShipment;
		
	/**
	 * @return the manifestNumber
	 */
	public String getManifestNumber() {
		return manifestNumber;
	}
	/**
	 * @param manifestNumber the manifestNumber to set
	 */
	public void setManifestNumber(String manifestNumber) {
		this.manifestNumber = manifestNumber;
	}
	/**
	 * @return the collectionCentre
	 */
	public String getCollectionCentre() {
		return collectionCentre;
	}
	/**
	 * @param collectionCentre the collectionCentre to set
	 */
	public void setCollectionCentre(String collectionCentre) {
		this.collectionCentre = collectionCentre;
	}
	/**
	 * @return the refNumber
	 */
	public String getRefNumber() {
		return refNumber;
	}
	/**
	 * @param refNumber the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	/**
	 * @return the dateSent
	 */
	public Date getDateSent() {
		return dateSent;
	}
	/**
	 * @param dateSent the dateSent to set
	 */
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	/**
	 * @return the numberOfBoxes
	 */
	public Integer getNumberOfBoxes() {
		return numberOfBoxes;
	}
	/**
	 * @param numberOfBoxes the numberOfBoxes to set
	 */
	public void setNumberOfBoxes(Integer numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}
	/**
	 * @return the responsiblePerson
	 */
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	/**
	 * @param responsiblePerson the responsiblePerson to set
	 */
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	/**
	 * @return the contactDetails
	 */
	public String getContactDetails() {
		return contactDetails;
	}
	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	/**
	 * @return the methodOfShipment
	 */
	public String getMethodOfShipment() {
		return methodOfShipment;
	}
	/**
	 * @param methodOfShipment the methodOfShipment to set
	 */
	public void setMethodOfShipment(String methodOfShipment) {
		this.methodOfShipment = methodOfShipment;
	}

	

}
