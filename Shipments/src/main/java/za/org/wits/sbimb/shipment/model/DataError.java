/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

import za.org.wits.sbimb.shipment.Constants.DataErrorType;

/**
 * @author Freedom Mukomana
 *
 */
public class DataError {
	DataErrorType dataErrorType;
	String message;
	
	/**
	 * @return the dataErrorType
	 */
	public DataErrorType getDataErrorType() {
		return dataErrorType;
	}
	/**
	 * @param dataErrorType the dataErrorType to set
	 */
	public void setDataErrorType(DataErrorType dataErrorType) {
		this.dataErrorType = dataErrorType;
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
