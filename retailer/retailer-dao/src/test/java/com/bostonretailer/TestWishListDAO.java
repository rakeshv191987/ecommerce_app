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
import com.bostonretailer.retailercommon.WishList;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.WishListDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestWishListDAO extends TestCase {
	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		WishListDao wishListDao = (WishListDao) appContext
				.getBean("wishListDao");
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
			WishList wishList = new WishList();
			wishList.setCustomer(customer);
			wishListDao.save(wishList);

			/** Find Shopping Cart **/
			WishList wishList1 = wishListDao.findWishList(wishList
					.getWishListId());
			assertNotNull(wishList1);

			/** Delete Shopping Cart **/
			wishListDao.delete(wishList1);
			WishList wishList2 = wishListDao.findWishList(wishList
					.getWishListId());
			assertNull(wishList2);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
