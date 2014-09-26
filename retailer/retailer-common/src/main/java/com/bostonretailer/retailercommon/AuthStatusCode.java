/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 *
 */
public enum AuthStatusCode {
	PENDING("pnd", "Pending for approval by Admin"), APPROVED("apr", "Approved for Business"), NOT_APPROVED(
			"napr", "Not Approved for Business");
	
	private String shortCode;
	private String description;

	private AuthStatusCode(String shortCode, String description) {
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

	public boolean equals(AuthStatusCode authStatusCode) {
		return this.shortCode.equals(authStatusCode.getShortCode())
				&& this.description.equals(authStatusCode.getDescription());
	}

	public static AuthStatusCode shortCodeLookup(String shortCode) {
		for (AuthStatusCode authStatusCode : AuthStatusCode.values())
			if (shortCode.equals(authStatusCode.getShortCode()))
				return authStatusCode;
		return null;
	}
}
