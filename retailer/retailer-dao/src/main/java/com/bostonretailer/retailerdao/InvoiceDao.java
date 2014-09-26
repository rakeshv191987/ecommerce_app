/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Invoice;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface InvoiceDao {
	public void save(Invoice invoice);

	public void delete(Invoice invoice);

	public void update(Invoice invoice);

	public Invoice findInvoice(Long invoiceId);
}
