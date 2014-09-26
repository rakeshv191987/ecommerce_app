/**
 * 
 */
package com.bostonretailer.retailerservices;

import java.util.List;

import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefProductType;
import com.bostonretailer.retailercommon.Vendor;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface AdminBOService {

	public void approveVendor(Long vendorId, String vendorAuthStatusCode);

	public Vendor findByVendorId(Long vendorId);

	/* Commodity Service Methods */

	public void approveCommodity(Long commodityId, String commodityStatusCode,
			RefProductType productType, String productImageFileName,
			int profitPercent);

	public Commodity findByCommodityId(Long commodityId);

	/* Product Service Methods */

	public void createProduct(Product product);

	public void deleteProduct(Product product);

	public void updateProduct(Product product);

	public Product findByProductId(Long productId);
	
	public List<Product> getAllProducts();

	/* End of Product Service Methods */

	/* Customer Order Approval */

	public void approveOrder(Long orderId);

	/* End of Customer Order Approval */

}
