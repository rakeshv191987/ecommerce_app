/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Shipment;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ShipmentDaoImpl extends DAOSupport implements ShipmentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.ShipmentDao#save(com.bostonretailer.
	 * retailercommon.Shipment)
	 */
	@Override
	public void save(Shipment shipment) {
		try {
			begin();
			getSession().save(shipment);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.ShipmentDao#delete(com.bostonretailer.
	 * retailercommon.Shipment)
	 */
	@Override
	public void delete(Shipment shipment) {
		try {
			begin();
			getSession().delete(shipment);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.ShipmentDao#update(com.bostonretailer.
	 * retailercommon.Shipment)
	 */
	@Override
	public void update(Shipment shipment) {
		try {
			begin();
			getSession().update(shipment);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.ShipmentDao#findShipment(java.lang.Long)
	 */
	@Override
	public Shipment findShipment(Long shipmentId) {
		try {
			Query q = getSession().createQuery(
					"from Shipment where shipmentTrackingNumber = :shipmentId");
			q.setLong("shipmentId", shipmentId);
			Shipment shipment = (Shipment) q.uniqueResult();
			return shipment;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
