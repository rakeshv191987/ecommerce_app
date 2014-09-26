/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.WishListProduct;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface WishListProductDao {
	public void save(WishListProduct wishListProduct);

	public void delete(WishListProduct wishListProduct);

	public void update(WishListProduct wishListProduct);

	public WishListProduct findWishListProduct(
			Long wishListProductId);
}
