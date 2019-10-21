/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import java.util.Date;

import za.org.wits.sbimb.shipment.Constants.AnticoagulantType;
import za.org.wits.sbimb.shipment.Constants.BiospecimenTypes;
import za.org.wits.sbimb.shipment.Constants.Biotransactions;
import za.org.wits.sbimb.shipment.Constants.Grade;
import za.org.wits.sbimb.shipment.Constants.Protocol;
import za.org.wits.sbimb.shipment.Constants.Quality;
import za.org.wits.sbimb.shipment.Constants.Status;
import za.org.wits.sbimb.shipment.Constants.StoredIn;
import za.org.wits.sbimb.shipment.Constants.Treatments;
import za.org.wits.sbimb.shipment.Constants.Units;

/**
 * @author Freedom Mukomana
 *
 */
public class ARKUpload {
	String biospecimenUId;
	String subjectuId;
	String biocollectionUId;
	String biocollectionName;
	Integer ageAtCollection;
	String biocollectionComments;
	Date biocollectionDate;
	String parentId;
	Double amountUsed;
	Biotransactions biotransaction;
	BiospecimenTypes sampleType;
	Date biospecimenCollectionDate;
	Date biospecimenCollectionTime;
	Date processdate;
	Date processtime;
	String comments;
	Boolean barcoded;
	Grade grade;
	StoredIn storedIn;
	AnticoagulantType anticoagulantType;
	Status status;
	Protocol protocol;
	Double purity280;
	Double purity230;
	Quality quality;
	Integer quantity;
	Units units;
	Treatments treatment;
	Double concentration;
	String site;
	String freezer;
	String shelf;
	String rack;
	String box;
	String row;
	String column;
		
	/**
	 * @return the biospecimenUId
	 */
	public String getBiospecimenUId() {
		return biospecimenUId;
	}
	/**
	 * @param biospecimenUId the biospecimenUId to set
	 */
	public void setBiospecimenUId(String biospecimenUId) {
		this.biospecimenUId = biospecimenUId;
	}
	/**
	 * @return the subjectuId
	 */
	public String getSubjectuId() {
		return subjectuId;
	}
	/**
	 * @param subjectuId the subjectuId to set
	 */
	public void setSubjectuId(String subjectuId) {
		this.subjectuId = subjectuId;
	}
	/**
	 * @return the biocollectionUId
	 */
	public String getBiocollectionUId() {
		return biocollectionUId;
	}
	/**
	 * @param biocollectionUId the biocollectionUId to set
	 */
	public void setBiocollectionUId(String biocollectionUId) {
		this.biocollectionUId = biocollectionUId;
	}
	/**
	 * @return the biocollectionName
	 */
	public String getBiocollectionName() {
		return biocollectionName;
	}
	/**
	 * @param biocollectionName the biocollectionName to set
	 */
	public void setBiocollectionName(String biocollectionName) {
		this.biocollectionName = biocollectionName;
	}
	/**
	 * @return the ageAtCollection
	 */
	public Integer getAgeAtCollection() {
		return ageAtCollection;
	}
	/**
	 * @param ageAtCollection the ageAtCollection to set
	 */
	public void setAgeAtCollection(Integer ageAtCollection) {
		this.ageAtCollection = ageAtCollection;
	}
	/**
	 * @return the biocollectionComments
	 */
	public String getBiocollectionComments() {
		return biocollectionComments;
	}
	/**
	 * @param biocollectionComments the biocollectionComments to set
	 */
	public void setBiocollectionComments(String biocollectionComments) {
		this.biocollectionComments = biocollectionComments;
	}
	/**
	 * @return the biocollectionDate
	 */
	public Date getBiocollectionDate() {
		return biocollectionDate;
	}
	/**
	 * @param biocollectionDate the biocollectionDate to set
	 */
	public void setBiocollectionDate(Date biocollectionDate) {
		this.biocollectionDate = biocollectionDate;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the amountUsed
	 */
	public Double getAmountUsed() {
		return amountUsed;
	}
	/**
	 * @param amountUsed the amountUsed to set
	 */
	public void setAmountUsed(Double amountUsed) {
		this.amountUsed = amountUsed;
	}
	/**
	 * @return the biotransaction
	 */
	public Biotransactions getBiotransaction() {
		return biotransaction;
	}
	/**
	 * @param biotransaction the biotransaction to set
	 */
	public void setBiotransaction(Biotransactions biotransaction) {
		this.biotransaction = biotransaction;
	}
	/**
	 * @return the sampleType
	 */
	public BiospecimenTypes getSampleType() {
		return sampleType;
	}
	/**
	 * @param sampleType the sampleType to set
	 */
	public void setSampleType(BiospecimenTypes sampleType) {
		this.sampleType = sampleType;
	}
	/**
	 * @return the biospecimenCollectionDate
	 */
	public Date getBiospecimenCollectionDate() {
		return biospecimenCollectionDate;
	}
	/**
	 * @param biospecimenCollectionDate the biospecimenCollectionDate to set
	 */
	public void setBiospecimenCollectionDate(Date biospecimenCollectionDate) {
		this.biospecimenCollectionDate = biospecimenCollectionDate;
	}
	/**
	 * @return the biospecimenCollectionTime
	 */
	public Date getBiospecimenCollectionTime() {
		return biospecimenCollectionTime;
	}
	/**
	 * @param biospecimenCollectionTime the biospecimenCollectionTime to set
	 */
	public void setBiospecimenCollectionTime(Date biospecimenCollectionTime) {
		this.biospecimenCollectionTime = biospecimenCollectionTime;
	}
	/**
	 * @return the processdate
	 */
	public Date getProcessdate() {
		return processdate;
	}
	/**
	 * @param processdate the processdate to set
	 */
	public void setProcessdate(Date processdate) {
		this.processdate = processdate;
	}
	/**
	 * @return the processtime
	 */
	public Date getProcesstime() {
		return processtime;
	}
	/**
	 * @param processtime the processtime to set
	 */
	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
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
	 * @return the barcoded
	 */
	public Boolean getBarcoded() {
		return barcoded;
	}
	/**
	 * @param barcoded the barcoded to set
	 */
	public void setBarcoded(Boolean barcoded) {
		this.barcoded = barcoded;
	}
	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	/**
	 * @return the storedIn
	 */
	public StoredIn getStoredIn() {
		return storedIn;
	}
	/**
	 * @param storedIn the storedIn to set
	 */
	public void setStoredIn(StoredIn storedIn) {
		this.storedIn = storedIn;
	}
	/**
	 * @return the anticoagulantType
	 */
	public AnticoagulantType getAnticoagulantType() {
		return anticoagulantType;
	}
	/**
	 * @param anticoagulantType the anticoagulantType to set
	 */
	public void setAnticoagulantType(AnticoagulantType anticoagulantType) {
		this.anticoagulantType = anticoagulantType;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the protocol
	 */
	public Protocol getProtocol() {
		return protocol;
	}
	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	/**
	 * @return the purity280
	 */
	public Double getPurity280() {
		return purity280;
	}
	/**
	 * @param purity280 the purity280 to set
	 */
	public void setPurity280(Double purity280) {
		this.purity280 = purity280;
	}
	/**
	 * @return the purity230
	 */
	public Double getPurity230() {
		return purity230;
	}
	/**
	 * @param purity230 the purity230 to set
	 */
	public void setPurity230(Double purity230) {
		this.purity230 = purity230;
	}
	/**
	 * @return the quality
	 */
	public Quality getQuality() {
		return quality;
	}
	/**
	 * @param quality the quality to set
	 */
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the units
	 */
	public Units getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(Units units) {
		this.units = units;
	}
	/**
	 * @return the treatment
	 */
	public Treatments getTreatment() {
		return treatment;
	}
	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(Treatments treatment) {
		this.treatment = treatment;
	}
	/**
	 * @return the concentration
	 */
	public Double getConcentration() {
		return concentration;
	}
	/**
	 * @param concentration the concentration to set
	 */
	public void setConcentration(Double concentration) {
		this.concentration = concentration;
	}
	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 * @return the freezer
	 */
	public String getFreezer() {
		return freezer;
	}
	/**
	 * @param freezer the freezer to set
	 */
	public void setFreezer(String freezer) {
		this.freezer = freezer;
	}
	/**
	 * @return the shelf
	 */
	public String getShelf() {
		return shelf;
	}
	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	/**
	 * @return the rack
	 */
	public String getRack() {
		return rack;
	}
	/**
	 * @param rack the rack to set
	 */
	public void setRack(String rack) {
		this.rack = rack;
	}
	/**
	 * @return the box
	 */
	public String getBox() {
		return box;
	}
	/**
	 * @param box the box to set
	 */
	public void setBox(String box) {
		this.box = box;
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
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}
}
