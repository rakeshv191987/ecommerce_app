/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Order;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface OrderDao {
	public void save(Order order);

	public void delete(Order order);

	public void update(Order order);

	public Order findOrder(Long orderId);
}
