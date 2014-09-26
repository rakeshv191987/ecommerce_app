/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public enum RefPaymentMethod {
	CREDIT_CARD("cc", "Credit Card Type"), DEBIT_CARD("dc", "Debit Card Type"), GIFT_CARD(
			"gc", "Gift Card Type");

	private String shortCode;
	private String description;

	private RefPaymentMethod(String shortCode, String description) {
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

	public boolean equals(RefPaymentMethod paymentMethod) {
		return this.shortCode.equals(paymentMethod.getShortCode())
				&& this.description.equals(paymentMethod.getDescription());
	}

	public static RefPaymentMethod shortCodeLookup(String shortCode) {
		for (RefPaymentMethod paymentMethod : RefPaymentMethod.values())
			if (shortCode.equals(paymentMethod.getShortCode()))
				return paymentMethod;
		return null;
	}

}
