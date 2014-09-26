/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.OrderItems;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class OrderItemsDaoImpl extends DAOSupport implements OrderItemsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.OrderItemsDao#save(com.bostonretailer.
	 * retailercommon.OrderItems)
	 */
	@Override
	public void save(OrderItems orderItem) {
		try {
			begin();
			getSession().save(orderItem);
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
	 * com.bostonretailer.retailerdao.OrderItemsDao#delete(com.bostonretailer
	 * .retailercommon.OrderItems)
	 */
	@Override
	public void delete(OrderItems orderItem) {
		try {
			begin();
			getSession().delete(orderItem);
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
	 * com.bostonretailer.retailerdao.OrderItemsDao#update(com.bostonretailer
	 * .retailercommon.OrderItems)
	 */
	@Override
	public void update(OrderItems orderItem) {
		try {
			begin();
			getSession().update(orderItem);
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
	 * com.bostonretailer.retailerdao.OrderItemsDao#findOrderItem(java.lang.
	 * Long)
	 */
	@Override
	public OrderItems findOrderItem(Long orderItemId) {
		try {
			Query q = getSession().createQuery(
					"from OrderItems where orderItemId = :orderItemId");
			q.setLong("orderItemId", orderItemId);
			OrderItems orderItem = (OrderItems) q.uniqueResult();
			return orderItem;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
