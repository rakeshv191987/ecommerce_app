/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.WishList;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class WishListDaoImpl extends DAOSupport implements WishListDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.WishListDao#save(com.bostonretailer.
	 * retailercommon.WishList)
	 */
	@Override
	public void save(WishList wishList) {
		try {
			begin();
			getSession().save(wishList);
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
	 * com.bostonretailer.retailerdao.WishListDao#delete(com.bostonretailer.
	 * retailercommon.WishList)
	 */
	@Override
	public void delete(WishList wishList) {
		try {
			begin();
			getSession().delete(wishList);
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
	 * com.bostonretailer.retailerdao.WishListDao#update(com.bostonretailer.
	 * retailercommon.WishList)
	 */
	@Override
	public void update(WishList wishList) {
		try {
			begin();
			getSession().update(wishList);
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
	 * com.bostonretailer.retailerdao.WishListDao#findWishList(java.lang.Long)
	 */
	@Override
	public WishList findWishList(Long wishListId) {
		try {
			Query q = getSession().createQuery(
					"from WishList where wishListId = :wishListId");
			q.setLong("wishListId", wishListId);
			WishList wishList = (WishList) q.uniqueResult();
			return wishList;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
