/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class WishList {
	private Long wishListId;
	private Customer customer;
	private List<WishListProduct> wishListProducts;

	public WishList() {

	}

	public WishList(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the wishListId
	 */
	public Long getWishListId() {
		return wishListId;
	}

	/**
	 * @param wishListId
	 *            the wishListId to set
	 */
	public void setWishListId(Long wishListId) {
		this.wishListId = wishListId;
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
	 * @return the wishListProducts
	 */
	public List<WishListProduct> getWishListProducts() {
		return wishListProducts;
	}

	/**
	 * @param wishListProducts
	 *            the wishListProducts to set
	 */
	public void setWishListProducts(List<WishListProduct> wishListProducts) {
		this.wishListProducts = wishListProducts;
	}

}
