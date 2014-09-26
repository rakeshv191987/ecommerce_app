/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.CustomerPaymentOption;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface CustomerPaymentOptionDao {
	public void save(CustomerPaymentOption customerPaymentOption);

	public void delete(CustomerPaymentOption customerPaymentOption);

	public void update(CustomerPaymentOption customerPaymentOption);

	public CustomerPaymentOption findCustomerPaymentOption(
			Long customerPaymentOptionId);

}
