/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Vendor {
	private Long vendorId;
	private String vendorName;
	private String displayName;
	private Address businessAddress;
	private String phoneNumber;
	private String emailAddress;
	private String password;
	private String bankAccountNumber;
	private List<Commodity> commodities = new ArrayList<>(0);
	private AuthStatusCode vendorAuthStatusCode;

	public Vendor() {
		this.vendorAuthStatusCode = AuthStatusCode.PENDING;
	}

	/**
	 * @return the vendorId
	 */
	public Long getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId
	 *            the vendorId to set
	 */
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName
	 *            the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	/**
	 * @param bankAccountNumber
	 *            the bankAccountNumber to set
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	/**
	 * @return the vendorAuthStatusCode
	 */
	public AuthStatusCode getVendorAuthStatusCode() {
		return vendorAuthStatusCode;
	}

	/**
	 * @param vendorAuthStatusCode
	 *            the vendorAuthStatusCode to set
	 */
	public void setVendorAuthStatusCode(AuthStatusCode vendorAuthStatusCode) {
		this.vendorAuthStatusCode = vendorAuthStatusCode;
	}

	/**
	 * @return the businessAddress
	 */
	public Address getBusinessAddress() {
		return businessAddress;
	}

	/**
	 * @param businessAddress
	 *            the businessAddress to set
	 */
	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * @param commodities
	 *            the commodities to set
	 */
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
