/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.OrderItems;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface OrderItemsDao {
	public void save(OrderItems orderItem);

	public void delete(OrderItems orderItem);

	public void update(OrderItems orderItem);

	public OrderItems findOrderItem(Long orderItemsId);
}
