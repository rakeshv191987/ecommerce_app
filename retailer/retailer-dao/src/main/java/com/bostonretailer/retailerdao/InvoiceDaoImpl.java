/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Invoice;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class InvoiceDaoImpl extends DAOSupport implements InvoiceDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.InvoiceDao#save(com.bostonretailer.
	 * retailercommon.Invoice)
	 */
	@Override
	public void save(Invoice invoice) {
		try {
			begin();
			getSession().save(invoice);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.InvoiceDao#delete(com.bostonretailer.
	 * retailercommon.Invoice)
	 */
	@Override
	public void delete(Invoice invoice) {
		try {
			begin();
			getSession().delete(invoice);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.InvoiceDao#update(com.bostonretailer.
	 * retailercommon.Invoice)
	 */
	@Override
	public void update(Invoice invoice) {
		try {
			begin();
			getSession().update(invoice);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.InvoiceDao#findInvoice(java.lang.Long)
	 */
	@Override
	public Invoice findInvoice(Long invoiceId) {
		try {
			Query q = getSession().createQuery(
					"from Invoice where invoiceNumber = :invoiceId");
			q.setLong("invoiceId", invoiceId);
			Invoice invoice = (Invoice) q.uniqueResult();
			return invoice;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
}
