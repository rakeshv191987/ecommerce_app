/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Order;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class OrderDaoImpl extends DAOSupport implements OrderDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.OrderDao#save(com.bostonretailer.
	 * retailercommon.Order)
	 */
	@Override
	public void save(Order order) {
		try {
			begin();
			getSession().save(order);
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
	 * @see com.bostonretailer.retailerdao.OrderDao#delete(com.bostonretailer.
	 * retailercommon.Order)
	 */
	@Override
	public void delete(Order order) {
		try {
			begin();
			getSession().delete(order);
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
	 * @see com.bostonretailer.retailerdao.OrderDao#update(com.bostonretailer.
	 * retailercommon.Order)
	 */
	@Override
	public void update(Order order) {
		try {
			begin();
			getSession().update(order);
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
	 * @see com.bostonretailer.retailerdao.OrderDao#findOrder(java.lang.Long)
	 */
	@Override
	public Order findOrder(Long orderId) {
		try {
			Query q = getSession().createQuery(
					"from Order where orderId = :orderId");
			q.setLong("orderId", orderId);
			Order order = (Order) q.uniqueResult();
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
