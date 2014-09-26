/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.WishList;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface WishListDao {
	public void save(WishList wishList);

	public void delete(WishList wishList);

	public void update(WishList wishList);

	public WishList findWishList(Long wishListId);
}
