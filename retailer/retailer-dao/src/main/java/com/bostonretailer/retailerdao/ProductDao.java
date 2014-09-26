/**
 * 
 */
package com.bostonretailer.retailerdao;

import java.util.List;

import com.bostonretailer.retailercommon.Product;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface ProductDao {
	public void save(Product product);

	public void delete(Product product);

	public void update(Product product);

	public Product findProductById(Long productId);

	public Product findProductByName(String productName);

	public List<Product> findProductsByQueryString(String queryString);
	
	public List<Product> getAllProducts();
}
