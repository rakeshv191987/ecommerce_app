/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Vendor;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class VendorDaoImpl extends DAOSupport implements VendorDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.VendorDao#save(com.bostonretailer.
	 * retailercommon.Vendor)
	 */
	@Override
	public void save(Vendor vendor) {
		try {
			begin();
			getSession().save(vendor);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.VendorDao#delete(com.bostonretailer.
	 * retailercommon.Vendor)
	 */
	@Override
	public void delete(Vendor vendor) {
		try {
			begin();
			getSession().delete(vendor);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.VendorDao#update(com.bostonretailer.
	 * retailercommon.Vendor)
	 */
	@Override
	public void update(Vendor vendor) {
		try {
			begin();
			getSession().update(vendor);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.VendorDao#findVendor(java.lang.Long)
	 */
	@Override
	public Vendor findVendor(Long vendorId) {
		try {
			Query q = getSession().createQuery(
					"from Vendor where vendorId = :vendorId");
			q.setLong("vendorId", vendorId);
			Vendor vendor = (Vendor) q.uniqueResult();
			return vendor;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
