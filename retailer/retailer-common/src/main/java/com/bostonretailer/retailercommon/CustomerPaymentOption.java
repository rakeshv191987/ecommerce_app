/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class CustomerPaymentOption {
	private Long customerPaymentOptionId;
	private Long customerId;
	private RefPaymentMethod paymentMethod;
	private String cardNumber;
	private String paymentMethodDetails;

	/**
	 * @return the customerPaymentOptionId
	 */
	public Long getCustomerPaymentOptionId() {
		return customerPaymentOptionId;
	}

	/**
	 * @param customerPaymentOptionId
	 *            the customerPaymentOptionId to set
	 */
	public void setCustomerPaymentOptionId(Long customerPaymentOptionId) {
		this.customerPaymentOptionId = customerPaymentOptionId;
	}

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
	 * @return the paymentMethod
	 */
	public RefPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 *            the paymentMethod to set
	 */
	public void setPaymentMethod(RefPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the paymentMethodDetails
	 */
	public String getPaymentMethodDetails() {
		return paymentMethodDetails;
	}

	/**
	 * @param paymentMethodDetails
	 *            the paymentMethodDetails to set
	 */
	public void setPaymentMethodDetails(String paymentMethodDetails) {
		this.paymentMethodDetails = paymentMethodDetails;
	}

}
