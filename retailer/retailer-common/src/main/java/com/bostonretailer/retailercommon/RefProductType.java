/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public enum RefProductType {
	MEN_SHOES("sh", "Men's Shoes"), MEN_PANTS("pt", "Men's Formal Shirts"), EDUCATIONAL_BOOKS(
			"bk", "Educational Books");

	private String shortCode;
	private String description;

	private RefProductType(String shortCode, String description) {
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

	public boolean equals(RefProductType productType) {
		return this.shortCode.equals(productType.getShortCode())
				&& this.description.equals(productType.getDescription());
	}

	public static RefProductType shortCodeLookup(String shortCode) {
		for (RefProductType productType : RefProductType.values())
			if (shortCode.equals(productType.getShortCode()))
				return productType;
		return null;
	}
}
