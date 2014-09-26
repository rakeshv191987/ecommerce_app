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

import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefProductType;
import com.bostonretailer.retailercommon.ShoppingCart;
import com.bostonretailer.retailercommon.ShoppingCartProduct;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.ShoppingCartDao;
import com.bostonretailer.retailerdao.ShoppingCartProductDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestShoppingCartProductDAO extends TestCase {
	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		ShoppingCartProductDao shoppingCartProductDao = (ShoppingCartProductDao) appContext
				.getBean("shoppingCartProductDao");
		ShoppingCartDao shoppingCartDao = (ShoppingCartDao) appContext
				.getBean("shoppingCartDao");
		ProductDao productDao = (ProductDao) appContext.getBean("productDao");
		CustomerDao customerDao = (CustomerDao) appContext
				.getBean("customerDao");

		try {
			/** Insert Shopping Cart **/
			Customer customer = new Customer();
			customer.setGender("M");
			customer.setFirstName("John");
			customer.setLastName("Doe");
			customer.setEmailAddress("Doe");
			customer.setPassword("Doe");
			customer.setPhoneNumber("Doe");
			customerDao.save(customer);
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setCustomer(customer);
			shoppingCartDao.save(shoppingCart);

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

			/** Insert Shopping Cart Product **/
			ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
			shoppingCartProduct.setProduct(product);
			shoppingCartProduct.setShoppingCart(shoppingCart);
			shoppingCartProduct.setQuantity(100);
			shoppingCartProductDao.save(shoppingCartProduct);
			assertNotNull(shoppingCartProduct);

			/** Find Shopping Cart Product **/
			ShoppingCartProduct shoppingCartProduct1 = shoppingCartProductDao
					.findShoppingCartProduct(shoppingCartProduct
							.getShoppingCartProductId());
			assertNotNull(shoppingCartProduct1);
			assertEquals(product.getProductId(), shoppingCartProduct1
					.getProduct().getProductId());
			assertEquals(shoppingCart.getShoppingCartId(), shoppingCartProduct1
					.getShoppingCart().getShoppingCartId());

			/** Update Shopping Cart Product **/
			shoppingCartProduct1.setQuantity(300);
			shoppingCartProductDao.save(shoppingCartProduct1);

			ShoppingCartProduct shoppingCartProduct2 = shoppingCartProductDao
					.findShoppingCartProduct(shoppingCartProduct1
							.getShoppingCartProductId());
			assertEquals(shoppingCartProduct2.getQuantity(),
					shoppingCartProduct1.getQuantity());

			/** Delete Shopping Cart Product **/
			ShoppingCartProduct shoppingCartProduct3 = null;
			shoppingCartProductDao.delete(shoppingCartProduct2);
			shoppingCartProduct3 = shoppingCartProductDao
					.findShoppingCartProduct(product.getProductId());
			assertNull(shoppingCartProduct3);
		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
