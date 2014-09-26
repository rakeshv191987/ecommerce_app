/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Payment;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class PaymentDaoImpl extends DAOSupport implements PaymentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.PaymentDao#save(com.bostonretailer.
	 * retailercommon.Payment)
	 */
	@Override
	public void save(Payment payment) {
		try {
			begin();
			getSession().save(payment);
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
	 * @see com.bostonretailer.retailerdao.PaymentDao#delete(com.bostonretailer.
	 * retailercommon.Payment)
	 */
	@Override
	public void delete(Payment payment) {
		try {
			begin();
			getSession().delete(payment);
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
	 * @see com.bostonretailer.retailerdao.PaymentDao#update(com.bostonretailer.
	 * retailercommon.Payment)
	 */
	@Override
	public void update(Payment payment) {
		try {
			begin();
			getSession().update(payment);
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
	 * com.bostonretailer.retailerdao.PaymentDao#findPayment(java.lang.Long)
	 */
	@Override
	public Payment findPayment(Long paymentId) {
		try {
			Query q = getSession().createQuery(
					"from Payment where paymentId = :paymentId");
			q.setLong("paymentId", paymentId);
			Payment payment = (Payment) q.uniqueResult();
			return payment;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
