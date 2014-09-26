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
import com.bostonretailer.retailercommon.WishList;
import com.bostonretailer.retailercommon.WishListProduct;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.WishListDao;
import com.bostonretailer.retailerdao.WishListProductDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestWishListProductDAO extends TestCase {

	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		WishListProductDao wishListProductDao = (WishListProductDao) appContext
				.getBean("wishListProductDao");
		WishListDao wishListDao = (WishListDao) appContext
				.getBean("wishListDao");
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
			WishList wishList = new WishList();
			wishList.setCustomer(customer);
			wishListDao.save(wishList);

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
			WishListProduct wishListProduct = new WishListProduct();
			wishListProduct.setProduct(product);
			wishListProduct.setWishList(wishList);
			wishListProductDao.save(wishListProduct);
			assertNotNull(wishListProduct);

			/** Find Shopping Cart Product **/
			WishListProduct wishListProduct1 = wishListProductDao
					.findWishListProduct(wishListProduct.getWishListProductId());
			assertNotNull(wishListProduct1);
			assertEquals(product.getProductId(), wishListProduct1.getProduct()
					.getProductId());
			assertEquals(wishList.getWishListId(), wishListProduct1
					.getWishList().getWishListId());

			/** Delete Shopping Cart Product **/
			wishListProductDao.delete(wishListProduct1);
			WishListProduct wishListProduct2 = wishListProductDao
					.findWishListProduct(product.getProductId());
			assertNull(wishListProduct2);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
