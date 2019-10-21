/**
 * 
 */
package za.org.wits.sbimb.shipment.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import za.org.wits.sbimb.shipment.model.Biospecimen;
import za.org.wits.sbimb.shipment.model.Participant;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;
import za.org.wits.sbimb.shipment.model.UploadResponse;

/**
 * @author Freedom Mukomana
 *
 */
public interface IConfirmUploadService {
	public List<UploadResponse> uploadShipment(ShipmentManifest shipmentManifest);
	public void linkParticipantToBiospecimen(ShipmentManifest shipmentManifest);
	public JSONArray compileParticipantData(ShipmentManifest shipmentManifest);
	public JSONObject convertParticipantToJSON(Participant participant, String manifestNumber);
	public JSONArray compileBiospecimenData(ShipmentManifest shipmentManifest);
	public JSONObject convertBiospecimenToJSON(Biospecimen biospecimen, String manifestNumber);
	public JSONArray compileBiospecimenUploadToJSON(ShipmentManifest shipmentManifest);
	public JSONObject convertBiospecimenUploadToJSON(Biospecimen biospecimen, String manifestNumber);
	public JSONArray compileShipmentData(ShipmentManifest shipmentManifest);
	public JSONObject convertShipmentToJSON(ShipmentManifest shipmentManifest);
}
