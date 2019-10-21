package za.org.wits.sbimb.shipment.model;
/**
 * 
 */

/**
 * @author Freedom Mukomana
 *
 */
public class Feedback {
	Boolean error;
	String note;
		
	/**
	 * @param isError
	 */
	public Feedback(Boolean error) {
		super();
		this.error = error;
	}
	
	/**
	 * @param isError
	 * @param note
	 */
	public Feedback(Boolean error, String note) {
		super();
		this.error = error;
		this.note = note;
	}

	public Boolean getError() {
		return error;
	}
	
	public void isError(Boolean error) {
		this.error = error;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}	
}
