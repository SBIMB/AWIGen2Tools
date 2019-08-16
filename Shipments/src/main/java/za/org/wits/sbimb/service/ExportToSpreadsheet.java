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
public abstract class ExportToSpreadsheet implements IExportToSpreadsheet {

	/* (non-Javadoc)
	 * @see za.org.wits.sbimb.service.IExportToSpreadsheet#convert(org.apache.poi.ss.usermodel.Workbook)
	 */
	public Workbook convert(ShipmentManifest shipmentManifest) {
		// TODO Auto-generated method stub
		return null;
	}

}
