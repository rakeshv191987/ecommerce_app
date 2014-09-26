/**
 * 
 */
package com.bostonretailer.retailerservices;

import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Vendor;
import com.bostonretailer.retailerdao.CommodityDao;
import com.bostonretailer.retailerdao.VendorDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class VendorBOServiceImpl implements VendorBOService {
	private VendorDao vendorDao;
	private CommodityDao commodityDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.VendorBOService#createVendor(com.
	 * bostonretailer.retailercommon.Vendor)
	 */
	@Override
	public void createVendor(Vendor vendor) {
		vendorDao.save(vendor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.VendorBOService#deleteVendor(com.
	 * bostonretailer.retailercommon.Vendor)
	 */
	@Override
	public void deleteVendor(Vendor vendor) {
		vendorDao.delete(vendor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.VendorBOService#updateVendor(com.
	 * bostonretailer.retailercommon.Vendor)
	 */
	@Override
	public void updateVendor(Vendor vendor) {
		vendorDao.update(vendor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerservices.VendorBOService#findByVendorId(java
	 * .lang.Long)
	 */
	@Override
	public Vendor findByVendorId(Long vendorId) {
		return vendorDao.findVendor(vendorId);
	}

	@Override
	public void createCommodity(Commodity commodity) {
		commodityDao.save(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		commodityDao.delete(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		commodityDao.update(commodity);
	}

	@Override
	public Commodity findByCommodityId(Long commodityId) {
		return commodityDao.findCommodity(commodityId);
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

}
