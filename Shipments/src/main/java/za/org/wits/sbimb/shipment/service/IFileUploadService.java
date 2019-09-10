/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import za.org.wits.sbimb.shipment.model.Feedback;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public interface IFileUploadService {
	public Feedback preStepOne(String filePath);
	public Feedback postStepOne(String filePath);
	public ShipmentManifest preStepTwo();
	public Feedback postStepTwo();
	public Feedback preStepThree();
	public Feedback postStepThree();
	public Feedback preStepFour();
	public Feedback postStepFour();
	public Feedback preStepFive();
	public Feedback postStepFive();
}
