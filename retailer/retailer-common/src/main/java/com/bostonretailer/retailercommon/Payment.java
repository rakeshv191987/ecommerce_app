/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.Date;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Payment {
	private Long paymentId;
	private Invoice invoice;
	private Date paymentDate;
	private Float paymentAmount;

	/**
	 * @return the paymentId
	 */
	public Long getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId
	 *            the paymentId to set
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	 * @return the paymentAmount
	 */
	public Float getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount
	 *            the paymentAmount to set
	 */
	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
