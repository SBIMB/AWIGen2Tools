/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedom Mukomana
 *
 */
public class Plate {
	String name;
	String biospecimenType;
	List<Biospecimen> biospecimens = new ArrayList<Biospecimen>();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
