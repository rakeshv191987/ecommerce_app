/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Payment;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface PaymentDao {
	public void save(Payment payment);

	public void delete(Payment payment);

	public void update(Payment payment);

	public Payment findPayment(Long paymentId);
}
