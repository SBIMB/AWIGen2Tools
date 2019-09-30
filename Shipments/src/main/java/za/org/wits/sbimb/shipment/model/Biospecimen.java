/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import java.util.Date;

/**
 * @author Freedom Mukomana
 *
 */
public class Biospecimen {
	String biospecimenID;
	String studyID;
	String gender;
	Date collectionDate;
	String biospecimenType;
	Plate plate;
	String row;
	String col;
	Boolean manualChecked;
	/**
	 * @return the biospecimenID
	 */
	public String getBiospecimenID() {
		return biospecimenID;
	}
	/**
	 * @param biospecimenID the biospecimenID to set
	 */
	public void setBiospecimenID(String biospecimenID) {
		this.biospecimenID = biospecimenID;
	}
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
	 * @return the collectionDate
	 */
	public Date getCollectionDate() {
		return collectionDate;
	}
	/**
	 * @param collectionDate the collectionDate to set
	 */
	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}
	/**
	 * @return the biospecimenType
	 */
	public String getBiospecimenType() {
		return biospecimenType;
	}
	/**
	 * @param biospecimenType the biospecimenType to set
	 */
	public void setBiospecimenType(String biospecimenType) {
		this.biospecimenType = biospecimenType;
	}
	/**
	 * @return the plate
	 */
	public Plate getPlate() {
		return plate;
	}
	/**
	 * @param plate the plate to set
	 */
	public void setPlate(Plate plate) {
		this.plate = plate;
	}
	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}
	/**
	 * @return the col
	 */
	public String getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(String col) {
		this.col = col;
	}
	/**
	 * @return the isMamualChecked
	 */
	public Boolean isManualChecked() {
		return manualChecked;
	}
	/**
	 * @param isMamualChecked the isMamualChecked to set
	 */
	public void setManualChecked(Boolean mamualChecked) {
		this.manualChecked = mamualChecked;
	}	
}
