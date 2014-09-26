/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Shipment;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface ShipmentDao {
	public void save(Shipment shipment);

	public void delete(Shipment shipment);

	public void update(Shipment shipment);

	public Shipment findShipment(Long shipmentId);
}
