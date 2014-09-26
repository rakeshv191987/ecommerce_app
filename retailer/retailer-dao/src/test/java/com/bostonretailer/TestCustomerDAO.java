package com.bostonretailer;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailercommon.ShoppingCart;
import com.bostonretailer.retailercommon.WishList;
import com.bostonretailer.retailerdao.AddressDao;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.ShoppingCartDao;
import com.bostonretailer.retailerdao.WishListDao;

/**
 * Unit test for simple App.
 */

@Transactional
public class TestCustomerDAO extends TestCase {

	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		CustomerDao customerDao = (CustomerDao) appContext
				.getBean("customerDao");
		AddressDao addressDao = (AddressDao) appContext.getBean("addressDao");
		ShoppingCartDao shoppingCartDao = (ShoppingCartDao) appContext
				.getBean("shoppingCartDao");
		WishListDao wishListDao = (WishListDao) appContext
				.getBean("wishListDao");

		try {
			/** Insert Customer **/
			Address address = new Address();
			address.setAddressLine1("200 Wall Street");
			address.setAddressLine2("New York");
			address.setCity("New York");
			address.setCountry("USA");
			address.setZipCode(3L);
			addressDao.save(address);

			Customer customer = new Customer();
			customer.setGender("M");
			customer.setFirstName("John");
			customer.setLastName("Doe");
			customer.setEmailAddress("Doe");
			customer.setPassword("Doe");
			customer.setPhoneNumber("Doe");
			customer.setAddress(address);
			customerDao.save(customer);
			assertNotNull(customer);

			/** Find Customer **/
			Customer customer1 = customerDao.findCustomer(customer
					.getCustomerId());
			assertNotNull(customer1);

			/** Update Customer **/
			customer1.setFirstName("Wayne");
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setCustomer(customer);
			shoppingCartDao.save(shoppingCart);
			WishList wishList = new WishList();
			wishList.setCustomer(customer);
			wishListDao.save(wishList);
			customerDao.update(customer1);

			Customer customer2;
			customer2 = customerDao.findCustomer(customer1.getCustomerId());
			assertEquals(customer2.getFirstName(), customer1.getFirstName());
			assertEquals(customer2.getWishList().getWishListId(),
					wishList.getWishListId());
			assertEquals(customer2.getShoppingCart().getShoppingCartId(),
					shoppingCart.getShoppingCartId());

			/** Delete Customer **/
			Customer customer3 = null;
			customerDao.delete(customer2);
			customer3 = customerDao.findCustomer(1L);
			assertNull(customer3);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}