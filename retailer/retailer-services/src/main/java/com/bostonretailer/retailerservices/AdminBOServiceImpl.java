/**
 * 
 */
package com.bostonretailer.retailerservices;

import java.util.List;

import com.bostonretailer.retailercommon.AuthStatusCode;
import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Order;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefOrderStatus;
import com.bostonretailer.retailercommon.RefProductType;
import com.bostonretailer.retailercommon.Shipment;
import com.bostonretailer.retailercommon.Vendor;
import com.bostonretailer.retailerdao.CommodityDao;
import com.bostonretailer.retailerdao.OrderDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.ShipmentDao;
import com.bostonretailer.retailerdao.VendorDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class AdminBOServiceImpl implements AdminBOService {
	private CommodityDao commodityDao;
	private ProductDao productDao;
	private VendorDao vendorDao;
	private ShipmentDao shipmentDao;
	private OrderDao orderDao;

	@Override
	public void approveVendor(Long vendorId, String vendorAuthStatusCode) {
		Vendor vendor = vendorDao.findVendor(vendorId);
		vendor.setVendorAuthStatusCode(AuthStatusCode.APPROVED);
		vendorDao.save(vendor);
	}

	@Override
	public Vendor findByVendorId(Long vendorId) {
		return vendorDao.findVendor(vendorId);
	}

	@Override
	public void approveCommodity(Long commodityId, String commodityStatusCode,
			RefProductType productType, String productImageFileName,
			int profitPercent) {
		Commodity commodity = commodityDao.findCommodity(commodityId);
		commodity.setCommodityStatusCode(AuthStatusCode.APPROVED);
		commodityDao.save(commodity);

		if (commodity.getCommodityStatusCode() == AuthStatusCode.NOT_APPROVED)
			return;

		Product product = productDao.findProductByName(commodity
				.getCommodityName());
		if (product != null) {
			product.setProductQuantity(commodity.getCommodityQuantity()
					+ product.getProductQuantity());
			productDao.save(product);
		} else {
			Product newProduct = new Product();

			newProduct.setProductName(commodity.getCommodityName());
			newProduct.setProductPrice(commodity.getCommodityPrice()
					+ (profitPercent * commodity.getCommodityPrice()) / 100);
			newProduct.setProductColor(commodity.getCommodityColor());
			newProduct.setProductSize(commodity.getCommoditySize());
			newProduct.setProductQuantity(commodity.getCommodityQuantity());
			newProduct.setProductDesc(commodity.getCommodityDesc());
			newProduct.setProductImageFileName(productImageFileName);
			productDao.save(newProduct);

			commodity.setProduct(newProduct);
			commodityDao.save(commodity);
		}
	}

	@Override
	public Commodity findByCommodityId(Long commodityId) {
		return commodityDao.findCommodity(commodityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.AdminBOService#createProduct(com.
	 * bostonretailer.retailercommon.Product)
	 */
	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.AdminBOService#deleteProduct(com.
	 * bostonretailer.retailercommon.Product)
	 */
	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.AdminBOService#updateProduct(com.
	 * bostonretailer.retailercommon.Product)
	 */
	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.AdminBOService#findByProductId(java
	 * .lang.Long)
	 */
	@Override
	public Product findByProductId(Long productId) {
		return productDao.findProductById(productId);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public void approveOrder(Long orderId) {
		Order order = orderDao.findOrder(orderId);
		order.setRefOrderStatus(RefOrderStatus.SHIPPED);

		Shipment shipment = new Shipment(order);
		shipment.setDateOrderDelivered(order.getDateOrderDelivery());
		shipmentDao.save(shipment);
	}

	/** Getter and Setter methods **/

	/**
	 * @return the commodityDao
	 */
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	/**
	 * @param commodityDao
	 *            the commodityDao to set
	 */
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	/**
	 * @return the productDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao
	 *            the productDao to set
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * @return the vendorDao
	 */
	public VendorDao getVendorDao() {
		return vendorDao;
	}

	/**
	 * @param vendorDao
	 *            the vendorDao to set
	 */
	public void setVendorDao(VendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	/**
	 * @return the shipmentDao
	 */
	public ShipmentDao getShipmentDao() {
		return shipmentDao;
	}

	/**
	 * @param shipmentDao
	 *            the shipmentDao to set
	 */
	public void setShipmentDao(ShipmentDao shipmentDao) {
		this.shipmentDao = shipmentDao;
	}

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao
	 *            the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
