/**
 * 
 */
package za.org.wits.sbimb.service;

import org.apache.poi.ss.usermodel.Workbook;

import za.org.wits.sbimb.shipment.model.ShipmentManifest;

/**
 * @author Freedom Mukomana
 *
 */
public interface IExportToSpreadsheet {
	
	public Workbook convert(ShipmentManifest shipmentManifest);

}
