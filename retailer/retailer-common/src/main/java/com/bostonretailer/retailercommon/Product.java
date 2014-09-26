/**
 * 
 */
package com.bostonretailer.retailercommon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class Product {
	private Long productId;
	private RefProductType productType;
	private List<Commodity> commodities = new ArrayList<>(0);
	private String productName;
	private Float productPrice;
	private String productColor;
	private int productSize;
	private int productQuantity;
	private String productDesc;
	private String productImageFileName;

	public Product() {

	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productType
	 */
	public RefProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(RefProductType productType) {
		this.productType = productType;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public Float getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productColor
	 */
	public String getProductColor() {
		return productColor;
	}

	/**
	 * @param productColor
	 *            the productColor to set
	 */
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	/**
	 * @return the productSize
	 */
	public int getProductSize() {
		return productSize;
	}

	/**
	 * @param productSize
	 *            the productSize to set
	 */
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity
	 *            the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc
	 *            the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return the productImageFileName
	 */
	public String getProductImageFileName() {
		return productImageFileName;
	}

	/**
	 * @param productImageFileName
	 *            the productImageFileName to set
	 */
	public void setProductImageFileName(String productImageFileName) {
		this.productImageFileName = productImageFileName;
	}

	/**
	 * @return the commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * @param commodities
	 *            the commodities to set
	 */
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

}
