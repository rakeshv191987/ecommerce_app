/**
 * 
 */
package com.bostonretailer.retailercommon;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Commodity {
	private Long commodityId;
	private Vendor vendor;
	private Product product;
	private String commodityName;
	private String commodityColor;
	private int commoditySize;
	private int commodityQuantity;
	private AuthStatusCode commodityStatusCode;
	private Float commodityPrice;
	private String commodityDesc;

	public Commodity() {
		this.commodityStatusCode = AuthStatusCode.PENDING;
	}

	/**
	 * @return the commodityId
	 */
	public Long getCommodityId() {
		return commodityId;
	}

	/**
	 * @param commodityId
	 *            the commodityId to set
	 */
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
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
	 * @return the commodityQuantity
	 */
	public int getCommodityQuantity() {
		return commodityQuantity;
	}

	/**
	 * @param commodityQuantity
	 *            the commodityQuantity to set
	 */
	public void setCommodityQuantity(int commodityQuantity) {
		this.commodityQuantity = commodityQuantity;
	}

	/**
	 * @return the commodityStatusCode
	 */
	public AuthStatusCode getCommodityStatusCode() {
		return commodityStatusCode;
	}

	/**
	 * @param commodityStatusCode
	 *            the commodityStatusCode to set
	 */
	public void setCommodityStatusCode(AuthStatusCode commodityStatusCode) {
		this.commodityStatusCode = commodityStatusCode;
	}

	/**
	 * @return the commodityPrice
	 */
	public Float getCommodityPrice() {
		return commodityPrice;
	}

	/**
	 * @param commodityPrice
	 *            the commodityPrice to set
	 */
	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	/**
	 * @return the commodityDesc
	 */
	public String getCommodityDesc() {
		return commodityDesc;
	}

	/**
	 * @param commodityDesc
	 *            the commodityDesc to set
	 */
	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}

	/**
	 * @return the commodityName
	 */
	public String getCommodityName() {
		return commodityName;
	}

	/**
	 * @param commodityName
	 *            the commodityName to set
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * @return the commodityColor
	 */
	public String getCommodityColor() {
		return commodityColor;
	}

	/**
	 * @param commodityColor
	 *            the commodityColor to set
	 */
	public void setCommodityColor(String commodityColor) {
		this.commodityColor = commodityColor;
	}

	/**
	 * @return the commoditySize
	 */
	public int getCommoditySize() {
		return commoditySize;
	}

	/**
	 * @param commoditySize
	 *            the commoditySize to set
	 */
	public void setCommoditySize(int commoditySize) {
		this.commoditySize = commoditySize;
	}

}
