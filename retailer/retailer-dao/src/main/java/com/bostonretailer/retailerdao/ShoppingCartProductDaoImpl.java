/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.ShoppingCartProduct;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ShoppingCartProductDaoImpl extends DAOSupport implements
		ShoppingCartProductDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.ShoppingCartProductDao#save(com.bostonretailer
	 * .retailercommon.ShoppingCartProduct)
	 */

	@Override
	public void save(ShoppingCartProduct shoppingCartProduct) {
		try {
			begin();
			getSession().save(shoppingCartProduct);
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
	 * @see com.bostonretailer.retailerdao.ShoppingCartProductDao#delete(com.
	 * bostonretailer.retailercommon.ShoppingCartProduct)
	 */
	@Override
	public void delete(ShoppingCartProduct shoppingCartProduct) {
		try {
			begin();
			getSession().delete(shoppingCartProduct);
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
	 * @see com.bostonretailer.retailerdao.ShoppingCartProductDao#update(com.
	 * bostonretailer.retailercommon.ShoppingCartProduct)
	 */
	@Override
	public void update(ShoppingCartProduct shoppingCartProduct) {
		try {
			begin();
			getSession().update(shoppingCartProduct);
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
	 * com.bostonretailer.retailerdao.ShoppingCartProductDao#findShoppingCartProduct
	 * (java.lang.Long)
	 */
	@Override
	public ShoppingCartProduct findShoppingCartProduct(
			Long shoppingCartProductId) {
		try {
			Query q = getSession()
					.createQuery(
							"from ShoppingCartProduct where shoppingCartProductId = :shoppingCartProductId");
			q.setLong("shoppingCartProductId", shoppingCartProductId);
			ShoppingCartProduct shoppingCartProduct = (ShoppingCartProduct) q
					.uniqueResult();
			return shoppingCartProduct;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
