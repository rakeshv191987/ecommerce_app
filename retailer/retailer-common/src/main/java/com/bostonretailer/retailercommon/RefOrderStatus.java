/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public enum RefOrderStatus {
	PENDING("pnd", "Order to be approved by Admin"), SHIPPED("shp", "Your order has been Shipped"), DELIVERED(
			"del", "Order has been Delivered");

	private String shortCode;
	private String description;

	private RefOrderStatus(String shortCode, String description) {
		this.shortCode = shortCode;
		this.description = description;
	}

	/**
	 * @return the shortCode
	 */
	public String getShortCode() {
		return shortCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public boolean equals(RefOrderStatus orderStatus) {
		return this.shortCode.equals(orderStatus.getShortCode())
				&& this.description.equals(orderStatus.getDescription());
	}

	public static RefOrderStatus shortCodeLookup(String shortCode) {
		for (RefOrderStatus orderStatus : RefOrderStatus.values())
			if (shortCode.equals(orderStatus.getShortCode()))
				return orderStatus;
		return null;
	}

}
