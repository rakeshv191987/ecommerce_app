/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Vendor;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface VendorDao {
	public void save(Vendor vendor);

	public void delete(Vendor vendor);

	public void update(Vendor vendor);

	public Vendor findVendor(Long vendorId);
}
