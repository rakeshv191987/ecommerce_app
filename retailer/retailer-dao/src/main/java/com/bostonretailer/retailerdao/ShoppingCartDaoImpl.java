/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.ShoppingCart;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ShoppingCartDaoImpl extends DAOSupport implements ShoppingCartDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.ShoppingCartDao#save(com.bostonretailer
	 * .retailercommon.ShoppingCart)
	 */
	@Override
	public void save(ShoppingCart shoppingCart) {
		try {
			begin();
			getSession().save(shoppingCart);
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
	 * com.bostonretailer.retailerdao.ShoppingCartDao#delete(com.bostonretailer
	 * .retailercommon.ShoppingCart)
	 */
	@Override
	public void delete(ShoppingCart shoppingCart) {
		try {
			begin();
			getSession().delete(shoppingCart);
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
	 * com.bostonretailer.retailerdao.ShoppingCartDao#update(com.bostonretailer
	 * .retailercommon.ShoppingCart)
	 */
	@Override
	public void update(ShoppingCart shoppingCart) {
		try {
			begin();
			getSession().update(shoppingCart);
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
	 * com.bostonretailer.retailerdao.ShoppingCartDao#findShoppingCart(java.
	 * lang.Long)
	 */
	@Override
	public ShoppingCart findShoppingCart(Long shoppingCartId) {
		try {
			Query q = getSession().createQuery(
					"from ShoppingCart where shoppingCartId = :shoppingCartId");
			q.setLong("shoppingCartId", shoppingCartId);
			ShoppingCart shoppingCart = (ShoppingCart) q.uniqueResult();
			return shoppingCart;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
}
