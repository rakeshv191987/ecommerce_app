/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Address;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface AddressDao {
	public void save(Address address);

	public void delete(Address address);

	public void update(Address address);

	public Address findAddress(Long addressId);
}
