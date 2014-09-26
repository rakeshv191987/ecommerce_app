/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.ShoppingCart;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface ShoppingCartDao {
	public void save(ShoppingCart shoppingCart);

	public void delete(ShoppingCart shoppingCart);

	public void update(ShoppingCart shoppingCart);

	public ShoppingCart findShoppingCart(Long shoppingCartId);
}
