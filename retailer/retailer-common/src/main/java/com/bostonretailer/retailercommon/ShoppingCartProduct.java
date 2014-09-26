/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ShoppingCartProduct {
	private Long shoppingCartProductId;
	private ShoppingCart shoppingCart;
	private Product product;
	private int quantity;

	public ShoppingCartProduct() {

	}

	public ShoppingCartProduct(ShoppingCart shoppingCart, Product product,
			int quantity) {
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the shoppingCartProductId
	 */
	public Long getShoppingCartProductId() {
		return shoppingCartProductId;
	}

	/**
	 * @param shoppingCartProductId
	 *            the shoppingCartProductId to set
	 */
	public void setShoppingCartProductId(Long shoppingCartProductId) {
		this.shoppingCartProductId = shoppingCartProductId;
	}

	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * @param shoppingCart
	 *            the shoppingCart to set
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
