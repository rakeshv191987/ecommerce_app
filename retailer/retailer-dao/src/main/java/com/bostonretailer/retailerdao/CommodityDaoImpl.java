/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Commodity;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class CommodityDaoImpl extends DAOSupport implements CommodityDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.CommodityDao#save(com.bostonretailer.
	 * retailercommon.Commodity)
	 */
	@Override
	public void save(Commodity commodity) {
		try {
			begin();
			getSession().save(commodity);
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
	 * @see
	 * com.bostonretailer.retailerdao.CommodityDao#delete(com.bostonretailer
	 * .retailercommon.Commodity)
	 */
	@Override
	public void delete(Commodity commodity) {
		try {
			begin();
			getSession().delete(commodity);
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
	 * @see
	 * com.bostonretailer.retailerdao.CommodityDao#update(com.bostonretailer
	 * .retailercommon.Commodity)
	 */
	@Override
	public void update(Commodity commodity) {
		try {
			begin();
			getSession().update(commodity);
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
	 * @see
	 * com.bostonretailer.retailerdao.CommodityDao#findCommodity(java.lang.Long)
	 */
	@Override
	public Commodity findCommodity(Long commodityId) {
		try {
			Query q = getSession().createQuery(
					"from Commodity where commodityId = :commodityId");
			q.setLong("commodityId", commodityId);
			Commodity commodity = (Commodity) q.uniqueResult();
			return commodity;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
