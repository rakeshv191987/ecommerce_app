/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.Date;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Invoice {
	private Long invoiceNumber;
	private Order order;
	private Date invoiceDate;
	private String invoiceDetails;
	private Payment payment;

	/**
	 * @return the invoiceNumber
	 */
	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber
	 *            the invoiceNumber to set
	 */
	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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
	 * @return the invoiceDate
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate
	 *            the invoiceDate to set
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * @return the invoiceDetails
	 */
	public String getInvoiceDetails() {
		return invoiceDetails;
	}

	/**
	 * @param invoiceDetails
	 *            the invoiceDetails to set
	 */
	public void setInvoiceDetails(String invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
