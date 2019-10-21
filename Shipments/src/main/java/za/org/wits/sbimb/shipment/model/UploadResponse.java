/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import za.org.wits.sbimb.shipment.Constants.UploadResponseType;

/**
 * @author Freedom Mukomana
 *
 */
public class UploadResponse {
	UploadResponseType uploadResponseType;
	String message;
	
	/**
	 * @return the dataResponseType
	 */
	public UploadResponseType getUploadResponseType() {
		return uploadResponseType;
	}
	/**
	 * @param dataResponseType the dataResponseType to set
	 */
	public void setDataResponseType(UploadResponseType uploadResponseType) {
		this.uploadResponseType = uploadResponseType;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
