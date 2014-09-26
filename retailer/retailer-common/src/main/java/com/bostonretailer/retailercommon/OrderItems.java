/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class OrderItems {
	private Long orderItemId;
	private Order order;
	private Product item;
	private int orderItemQuantity;
	private Float orderItemPrice;
	private String orderItemDetails;

	public OrderItems() {

	}

	public OrderItems(Order order, Product item, int orderItemQuantity,
			Float orderItemPrice) {
		this.order = order;
		this.item = item;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}

	/**
	 * @return the orderItemId
	 */
	public Long getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId
	 *            the orderItemId to set
	 */
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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
	 * @return the orderItemQuantity
	 */
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	/**
	 * @param orderItemQuantity
	 *            the orderItemQuantity to set
	 */
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	/**
	 * @return the orderItemDetails
	 */
	public String getOrderItemDetails() {
		return orderItemDetails;
	}

	/**
	 * @param orderItemDetails
	 *            the orderItemDetails to set
	 */
	public void setOrderItemDetails(String orderItemDetails) {
		this.orderItemDetails = orderItemDetails;
	}

	/**
	 * @return the item
	 */
	public Product getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(Product item) {
		this.item = item;
	}

	/**
	 * @return the orderItemPrice
	 */
	public Float getOrderItemPrice() {
		return orderItemPrice;
	}

	/**
	 * @param orderItemPrice
	 *            the orderItemPrice to set
	 */
	public void setOrderItemPrice(Float orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

}
