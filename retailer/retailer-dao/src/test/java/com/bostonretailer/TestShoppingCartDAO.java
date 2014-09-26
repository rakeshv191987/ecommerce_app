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
import com.bostonretailer.retailercommon.ShoppingCart;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.ShoppingCartDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestShoppingCartDAO extends TestCase {
	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		ShoppingCartDao shoppingCartDao = (ShoppingCartDao) appContext
				.getBean("shoppingCartDao");
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

			/** Find Shopping Cart **/
			ShoppingCart shoppingCart1 = shoppingCartDao
					.findShoppingCart(shoppingCart.getShoppingCartId());
			assertNotNull(shoppingCart1);

			/** Delete Shopping Cart **/
			ShoppingCart shoppingCart2 = null;
			shoppingCartDao.delete(shoppingCart1);
			shoppingCart2 = shoppingCartDao.findShoppingCart(shoppingCart
					.getShoppingCartId());
			assertNull(shoppingCart2);
		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
