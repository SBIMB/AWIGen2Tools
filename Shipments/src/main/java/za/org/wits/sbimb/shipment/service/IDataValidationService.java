/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.util.List;

import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.DataError;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public interface IDataValidationService {
	public List<DataError> checkDataErrors(ShipmentManifest shipmentManifest);
	public List<DataError> checkManifestErrors(ShipmentManifest shipmentManifest);
	public List<DataError> checkBiospecimenErrors(Biospecimen biospecimen);
	public List<DataError> checkParticipantErrors(Participant participant);
	public List<DataError> checkDataMissingness();	
}
