/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.ShoppingCartProduct;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface ShoppingCartProductDao {
	public void save(ShoppingCartProduct shoppingCartProduct);

	public void delete(ShoppingCartProduct shoppingCartProduct);

	public void update(ShoppingCartProduct shoppingCartProduct);

	public ShoppingCartProduct findShoppingCartProduct(
			Long shoppingCartProductId);
}
