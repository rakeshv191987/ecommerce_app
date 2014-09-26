/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */

public class Customer {
	private Long customerId;
	private String gender;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String phoneNumber;
	private Address address;
	private List<CustomerPaymentOption> customerPaymentOption;
	private List<Order> orders;
	private ShoppingCart shoppingCart;
	private WishList wishList;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the customerPaymentOption
	 */
	public List<CustomerPaymentOption> getCustomerPaymentOption() {
		return customerPaymentOption;
	}

	/**
	 * @param customerPaymentOption
	 *            the customerPaymentOption to set
	 */
	public void setCustomerPaymentOption(
			List<CustomerPaymentOption> customerPaymentOption) {
		this.customerPaymentOption = customerPaymentOption;
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * @param shoppingCart
	 *            the shoppingCart to set
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * @return the wishList
	 */
	public WishList getWishList() {
		return wishList;
	}

	/**
	 * @param wishList
	 *            the wishList to set
	 */
	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

}
