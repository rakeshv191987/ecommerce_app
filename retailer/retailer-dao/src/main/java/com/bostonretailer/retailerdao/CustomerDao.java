package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Customer;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface CustomerDao {
	public void save(Customer customer);

	public void delete(Customer customer);

	public void update(Customer customer);

	public Customer findCustomer(Long customerId);
}
