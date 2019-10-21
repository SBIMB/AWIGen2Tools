/**
 * 
 */
package za.org.wits.sbimb.shipment.model;

/**
 * @author Freedom Mukomana
 *
 */
public class FileStructureNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2998820757676639457L;

	/**
	 * 
	 */
	public FileStructureNotValidException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FileStructureNotValidException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FileStructureNotValidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FileStructureNotValidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FileStructureNotValidException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
