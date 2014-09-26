/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class WishListProduct {
	private Long wishListProductId;
	private WishList wishList;
	private Product product;

	public WishListProduct() {

	}

	public WishListProduct(WishList wishList, Product product) {
		this.wishList = wishList;
		this.product = product;
	}

	/**
	 * @return the wishListProductId
	 */
	public Long getWishListProductId() {
		return wishListProductId;
	}

	/**
	 * @param wishListProductId
	 *            the wishListProductId to set
	 */
	public void setWishListProductId(Long wishListProductId) {
		this.wishListProductId = wishListProductId;
	}

	/**
	 * @return the wishList
	 */
	public WishList getWishList() {
		return wishList;
	}

	/**
	 * @param wishList
	 *            the wishList to set
	 */
	public void setWishList(WishList wishList) {
		this.wishList = wishList;
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

}
