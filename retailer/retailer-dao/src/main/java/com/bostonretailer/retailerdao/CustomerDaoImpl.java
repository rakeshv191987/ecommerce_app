/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Customer;

/**
 * @author Rakesh_Viswanathan
 * 
 */

public class CustomerDaoImpl extends DAOSupport implements CustomerDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.CustomerDao#save(com.bostonretailer.
	 * retailercommon.Customer)
	 */
	@Override
	public void save(Customer customer) {
		try {
			begin();
			getSession().save(customer);
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
	 * com.bostonretailer.retailerdao.CustomerDao#delete(com.bostonretailer.
	 * retailercommon.Customer)
	 */
	@Override
	public void delete(Customer customer) {
		try {
			begin();
			getSession().delete(customer);
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
	 * com.bostonretailer.retailerdao.CustomerDao#update(com.bostonretailer.
	 * retailercommon.Customer)
	 */
	@Override
	public void update(Customer customer) {
		try {
			begin();
			getSession().update(customer);
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
	 * com.bostonretailer.retailerdao.CustomerDao#findCustomer(java.lang.Long)
	 */
	@Override
	public Customer findCustomer(Long customerId) {
		try {
			Query q = getSession().createQuery(
					"from Customer where customerId = :customerId");
			q.setLong("customerId", customerId);
			Customer customer = (Customer) q.uniqueResult();
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
}
