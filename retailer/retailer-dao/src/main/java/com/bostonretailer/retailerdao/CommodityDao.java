/**
 * 
 */
package com.bostonretailer.retailerdao;

import com.bostonretailer.retailercommon.Commodity;

/**
 * @author Rakesh_Viswanathan
 *
 */
public interface CommodityDao {
	public void save(Commodity commodity);

	public void delete(Commodity commodity);

	public void update(Commodity commodity);

	public Commodity findCommodity(Long commodityId);
}
