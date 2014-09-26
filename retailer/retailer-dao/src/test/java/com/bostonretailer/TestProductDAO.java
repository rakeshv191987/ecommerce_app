/**
 * 
 */
package com.bostonretailer;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bostonretailer.retailercommon.AuthStatusCode;
import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefProductType;
import com.bostonretailer.retailerdao.CommodityDao;
import com.bostonretailer.retailerdao.ProductDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestProductDAO extends TestCase {

	@Test
	public void testProductDAO() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		CommodityDao commodityDao = (CommodityDao) appContext
				.getBean("commodityDao");
		ProductDao productDao = (ProductDao) appContext.getBean("productDao");

		try {

			Commodity commodity = new Commodity();

			commodity.setCommodityName("Cracking the Coding Interview");
			commodity.setCommodityColor("White");
			commodity.setCommoditySize(4);
			commodity.setCommodityQuantity(100);
			commodity.setCommodityPrice(40F);
			commodity.setCommodityDesc("Crack IT company's interview");
			commodity.setCommodityStatusCode(AuthStatusCode.PENDING);
			commodityDao.save(commodity);

			Commodity commodity1 = new Commodity();

			commodity1.setCommodityName("Cracking the Coding Interview");
			commodity1.setCommodityColor("White");
			commodity1.setCommoditySize(4);
			commodity1.setCommodityQuantity(200);
			commodity1.setCommodityPrice(40F);
			commodity1.setCommodityDesc("Crack IT company's interview");
			commodity1.setCommodityStatusCode(AuthStatusCode.PENDING);
			commodityDao.save(commodity1);

			/** Insert Product **/
			Product product = new Product();
			product.setProductType(RefProductType.EDUCATIONAL_BOOKS);
			product.setProductName("Cracking the Coding Interview");
			product.setProductPrice(40F);
			product.setProductColor("White");
			product.setProductSize(4);
			product.setProductQuantity(100);
			product.setProductDesc("Crack IT company's interview");
			product.setProductImageFileName("/home/rakesh/images/img1.png");
			productDao.save(product);

			/** Find Product **/
			Product product1 = productDao.findProductById(product
					.getProductId());
			assertNotNull(product1);

			/** Update Product **/
			product1.getCommodities().add(commodity);
			productDao.update(product1);

			Product product2;
			product2 = productDao.findProductById(product1.getProductId());
			assertEquals(product2.getCommodities().size(), product1
					.getCommodities().size());

			/** Update Product **/
			product2.getCommodities().add(commodity1);
			productDao.update(product2);

			Product product3 = productDao.findProductById(product2.getProductId());
			assertEquals(product2.getCommodities().size(), product3
					.getCommodities().size());

			/** Delete Product **/
			productDao.delete(product3);
			product3 = productDao.findProductById(product2.getProductId());
			assertNull(product3);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
