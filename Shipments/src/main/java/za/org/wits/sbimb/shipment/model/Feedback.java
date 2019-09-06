package za.org.wits.sbimb.shipment.model;
/**
 * 
 */

/**
 * @author Freedom Mukomana
 *
 */
public class Feedback {
	Boolean isError;
	String note;
		
	/**
	 * @param isError
	 */
	public Feedback(Boolean isError) {
		super();
		this.isError = isError;
	}
	
	/**
	 * @param isError
	 * @param note
	 */
	public Feedback(Boolean isError, String note) {
		super();
		this.isError = isError;
		this.note = note;
	}

	public Boolean getIsError() {
		return isError;
	}
	
	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}	
}
