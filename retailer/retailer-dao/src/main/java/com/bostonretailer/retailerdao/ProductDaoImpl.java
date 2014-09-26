/**
 * 
 */
package com.bostonretailer.retailerdao;

import java.util.List;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Product;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class ProductDaoImpl extends DAOSupport implements ProductDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.ProductDao#save(com.bostonretailer.
	 * retailercommon.Product)
	 */
	@Override
	public void save(Product product) {
		try {
			begin();
			getSession().save(product);
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
	 * @see com.bostonretailer.retailerdao.ProductDao#delete(com.bostonretailer.
	 * retailercommon.Product)
	 */
	@Override
	public void delete(Product product) {
		try {
			begin();
			getSession().delete(product);
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
	 * @see com.bostonretailer.retailerdao.ProductDao#update(com.bostonretailer.
	 * retailercommon.Product)
	 */
	@Override
	public void update(Product product) {
		try {
			begin();
			getSession().update(product);
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
	 * com.bostonretailer.retailerdao.ProductDao#findProduct(java.lang.Long)
	 */
	@Override
	public Product findProductById(Long productId) {
		try {
			Query q = getSession().createQuery(
					"from Product where productId = :productId");
			q.setLong("productId", productId);
			Product product = (Product) q.uniqueResult();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

	@Override
	public Product findProductByName(String productName) {
		try {
			Query q = getSession().createQuery(
					"from Product where productName = :productName");
			q.setString("productName", productName);
			Product product = (Product) q.uniqueResult();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByQueryString(String queryString) {
		try {
			Query q = getSession().createQuery(
					"from Product where productName like :queryString");
			q.setString("queryString", queryString);
			return q.list();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		try {
			Query q = getSession().createQuery(
					"from Product p ORDER BY p.productId asc").setMaxResults(9);
			return q.list();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
}
