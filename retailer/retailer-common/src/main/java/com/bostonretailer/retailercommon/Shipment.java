/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.Date;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Shipment {
	private Long shipmentTrackingNumber;
	private Order order;
	private Date shipmentDate;
	private Date dateOrderDelivered;
	private String otherShipmentDetails;

	public Shipment() {

	}

	public Shipment(Order order) {
		String Message = "Your order has now been Shipped";
		this.order = order;
		this.shipmentDate = new Date();
		this.otherShipmentDetails = Message;
	}

	/**
	 * @return the shipmentTrackingNumber
	 */
	public Long getShipmentTrackingNumber() {
		return shipmentTrackingNumber;
	}

	/**
	 * @param shipmentTrackingNumber
	 *            the shipmentTrackingNumber to set
	 */
	public void setShipmentTrackingNumber(Long shipmentTrackingNumber) {
		this.shipmentTrackingNumber = shipmentTrackingNumber;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the shipmentDate
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * @param shipmentDate
	 *            the shipmentDate to set
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * @return the otherShipmentDetails
	 */
	public String getOtherShipmentDetails() {
		return otherShipmentDetails;
	}

	/**
	 * @param otherShipmentDetails
	 *            the otherShipmentDetails to set
	 */
	public void setOtherShipmentDetails(String otherShipmentDetails) {
		this.otherShipmentDetails = otherShipmentDetails;
	}

	/**
	 * @return the dateOrderDelivered
	 */
	public Date getDateOrderDelivered() {
		return dateOrderDelivered;
	}

	/**
	 * @param dateOrderDelivered
	 *            the dateOrderDelivered to set
	 */
	public void setDateOrderDelivered(Date dateOrderDelivered) {
		this.dateOrderDelivered = dateOrderDelivered;
	}

}
