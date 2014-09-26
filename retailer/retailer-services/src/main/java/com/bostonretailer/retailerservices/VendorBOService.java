/**
 * 
 */
package com.bostonretailer.retailerservices;

import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Vendor;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface VendorBOService {
	
	/* Vendor Service Methods */
	public void createVendor(Vendor vendor);

	public void deleteVendor(Vendor vendor);

	public void updateVendor(Vendor vendor);

	public Vendor findByVendorId(Long vendorId);
	
	/* Commodity Service Methods */
	public void createCommodity(Commodity commodity);

	public void deleteCommodity(Commodity commodity);

	public void updateCommodity(Commodity commodity);

	public Commodity findByCommodityId(Long commodityId);
	
	// TODO : Vendor Service to see sold commodities
}
