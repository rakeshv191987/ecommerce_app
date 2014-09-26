/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.CustomerPaymentOption;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class CustomerPaymentOptionDaoImpl extends DAOSupport implements
		CustomerPaymentOptionDao {

	@Override
	public void save(CustomerPaymentOption customerPaymentOption) {
		try {
			begin();
			getSession().save(customerPaymentOption);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	@Override
	public void delete(CustomerPaymentOption customerPaymentOption) {
		try {
			begin();
			getSession().delete(customerPaymentOption);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	@Override
	public void update(CustomerPaymentOption customerPaymentOption) {
		try {
			begin();
			getSession().update(customerPaymentOption);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	@Override
	public CustomerPaymentOption findCustomerPaymentOption(
			Long customerPaymentOptionId) {
		try {
			Query q = getSession()
					.createQuery(
							"from CustomerPaymentOption where customerPaymentOptionId = :customerPaymentOptionId");
			q.setLong("customerPaymentOptionId", customerPaymentOptionId);
			CustomerPaymentOption customerPaymentOption = (CustomerPaymentOption) q
					.uniqueResult();
			return customerPaymentOption;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
