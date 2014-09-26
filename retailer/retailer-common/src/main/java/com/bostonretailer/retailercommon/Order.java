/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.Date;
import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Order {
	private Long orderId;
	private Customer customer;
	private RefOrderStatus refOrderStatus;
	private Date dateOrderPlaced;
	private String orderDetails;
	private Date dateOrderExpectedDelivery;
	private Date dateOrderDelivery;
	private Address orderAddress;
	private Invoice invoice;
	private Shipment shipment;
	private List<OrderItems> orderItem;

	public Order() {

	}

	public Order(Customer customer, RefOrderStatus refOrderStatus,
			Date dateOrderExpectedDelivery, Address orderAddress) {
		this.customer = customer;
		this.refOrderStatus = refOrderStatus;
		this.dateOrderPlaced = new Date();
		this.orderDetails = "Your order is currently being processed";
		this.dateOrderExpectedDelivery = dateOrderExpectedDelivery;
		this.orderAddress = orderAddress;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the refOrderStatus
	 */
	public RefOrderStatus getRefOrderStatus() {
		return refOrderStatus;
	}

	/**
	 * @param refOrderStatus
	 *            the refOrderStatus to set
	 */
	public void setRefOrderStatus(RefOrderStatus refOrderStatus) {
		this.refOrderStatus = refOrderStatus;
	}

	/**
	 * @return the dateOrderPlaced
	 */
	public Date getDateOrderPlaced() {
		return dateOrderPlaced;
	}

	/**
	 * @param dateOrderPlaced
	 *            the dateOrderPlaced to set
	 */
	public void setDateOrderPlaced(Date dateOrderPlaced) {
		this.dateOrderPlaced = dateOrderPlaced;
	}

	/**
	 * @return the orderDetails
	 */
	public String getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails
	 *            the orderDetails to set
	 */
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * @return the dateOrderExpectedDelivery
	 */
	public Date getDateOrderExpectedDelivery() {
		return dateOrderExpectedDelivery;
	}

	/**
	 * @param dateOrderExpectedDelivery
	 *            the dateOrderExpectedDelivery to set
	 */
	public void setDateOrderExpectedDelivery(Date dateOrderExpectedDelivery) {
		this.dateOrderExpectedDelivery = dateOrderExpectedDelivery;
	}

	/**
	 * @return the dateOrderDelivery
	 */
	public Date getDateOrderDelivery() {
		return dateOrderDelivery;
	}

	/**
	 * @param dateOrderDelivery
	 *            the dateOrderDelivery to set
	 */
	public void setDateOrderDelivery(Date dateOrderDelivery) {
		this.dateOrderDelivery = dateOrderDelivery;
	}

	/**
	 * @return the orderAddress
	 */
	public Address getOrderAddress() {
		return orderAddress;
	}

	/**
	 * @param orderAddress
	 *            the orderAddress to set
	 */
	public void setOrderAddress(Address orderAddress) {
		this.orderAddress = orderAddress;
	}

	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice
	 *            the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * @return the shipment
	 */
	public Shipment getShipment() {
		return shipment;
	}

	/**
	 * @param shipment
	 *            the shipment to set
	 */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	/**
	 * @return the orderItem
	 */
	public List<OrderItems> getOrderItem() {
		return orderItem;
	}

	/**
	 * @param orderItem
	 *            the orderItem to set
	 */
	public void setOrderItem(List<OrderItems> orderItem) {
		this.orderItem = orderItem;
	}

}
