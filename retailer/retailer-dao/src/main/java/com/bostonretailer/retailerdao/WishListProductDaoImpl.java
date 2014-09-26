/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.WishListProduct;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class WishListProductDaoImpl extends DAOSupport implements
		WishListProductDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.WishListProductDao#save(com.bostonretailer
	 * .retailercommon.WishListProduct)
	 */
	@Override
	public void save(WishListProduct wishListProduct) {
		try {
			begin();
			getSession().save(wishListProduct);
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
	 * com.bostonretailer.retailerdao.WishListProductDao#delete(com.bostonretailer
	 * .retailercommon.WishListProduct)
	 */
	@Override
	public void delete(WishListProduct wishListProduct) {
		try {
			begin();
			getSession().delete(wishListProduct);
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
	 * com.bostonretailer.retailerdao.WishListProductDao#update(com.bostonretailer
	 * .retailercommon.WishListProduct)
	 */
	@Override
	public void update(WishListProduct wishListProduct) {
		try {
			begin();
			getSession().update(wishListProduct);
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
	 * com.bostonretailer.retailerdao.WishListProductDao#findWishListProduct
	 * (java.lang.Long)
	 */
	@Override
	public WishListProduct findWishListProduct(Long wishListProductId) {
		try {
			Query q = getSession()
					.createQuery(
							"from WishListProduct where wishListProductId = :wishListProductId");
			q.setLong("wishListProductId", wishListProductId);
			WishListProduct wishListProduct = (WishListProduct) q
					.uniqueResult();
			return wishListProduct;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
