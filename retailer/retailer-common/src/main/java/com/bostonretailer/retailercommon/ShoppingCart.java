/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ShoppingCart {
	private Long shoppingCartId;
	private Customer customer;
	private List<ShoppingCartProduct> shoppingCartProducts;

	public ShoppingCart() {
	}

	public ShoppingCart(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the shoppingCartId
	 */
	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	/**
	 * @param shoppingCartId
	 *            the shoppingCartId to set
	 */
	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the shoppingCartProducts
	 */
	public List<ShoppingCartProduct> getShoppingCartProducts() {
		return shoppingCartProducts;
	}

	/**
	 * @param shoppingCartProducts
	 *            the shoppingCartProducts to set
	 */
	public void setShoppingCartProducts(
			List<ShoppingCartProduct> shoppingCartProducts) {
		this.shoppingCartProducts = shoppingCartProducts;
	}

}
