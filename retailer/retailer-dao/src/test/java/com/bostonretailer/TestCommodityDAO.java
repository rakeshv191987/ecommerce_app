/**
 * 
 */
package com.bostonretailer;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.AuthStatusCode;
import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefProductType;
import com.bostonretailer.retailercommon.Vendor;
import com.bostonretailer.retailerdao.AddressDao;
import com.bostonretailer.retailerdao.CommodityDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.VendorDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestCommodityDAO extends TestCase {
	public void testProductDAO() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		CommodityDao commodityDao = (CommodityDao) appContext
				.getBean("commodityDao");
		VendorDao vendorDao = (VendorDao) appContext.getBean("vendorDao");
		ProductDao productDao = (ProductDao) appContext.getBean("productDao");
		AddressDao addressDao = (AddressDao) appContext.getBean("addressDao");

		try {
			/** Setup Init **/
			Address address = new Address();
			address.setAddressLine1("135 Clinton Street");
			address.setAddressLine2("Newton Crossing");
			address.setCity("New York");
			address.setCountry("USA");
			address.setZipCode(1L);
			addressDao.save(address);

			Vendor vendor = new Vendor();
			vendor.setBusinessAddress(address);
			vendor.setVendorName("Adidas");
			vendor.setDisplayName("Adidas");
			vendor.setBusinessAddress(address);
			vendor.setPhoneNumber("1234567898");
			vendor.setEmailAddress("manufacturer@adidas.com");
			vendor.setPassword("adidas");
			vendor.setBankAccountNumber("0123456789012");
			vendor.setVendorAuthStatusCode(AuthStatusCode.PENDING);
			vendor.setBusinessAddress(address);
			vendorDao.save(vendor);

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

			/** Insert Commodity **/
			Commodity commodity = new Commodity();
			commodity.setVendor(vendor);
			commodity.setProduct(product);
			commodity.setCommodityName("Cracking the Coding Interview");
			commodity.setCommodityColor("White");
			commodity.setCommoditySize(4);
			commodity.setCommodityQuantity(100);
			commodity.setCommodityPrice(40F);
			commodity.setCommodityDesc("Crack IT company's interview");
			commodity.setCommodityStatusCode(AuthStatusCode.PENDING);
			commodityDao.save(commodity);

			/** Find Commodity **/
			Commodity commodity1 = commodityDao.findCommodity(commodity
					.getCommodityId());
			assertNotNull(commodity1);
			assertEquals(commodity1.getVendor().getVendorId(),
					vendor.getVendorId());
			assertEquals(commodity1.getProduct().getProductId(),
					product.getProductId());

			/** Update Commodity **/
			commodity1.setCommodityName("Coding Interview Reading");
			commodity1.setCommodityStatusCode(AuthStatusCode.APPROVED);
			commodityDao.update(commodity1);

			Commodity commodity2;
			commodity2 = commodityDao
					.findCommodity(commodity1.getCommodityId());
			assertEquals(commodity2.getCommodityName(),
					commodity1.getCommodityName());
			assertEquals(commodity2.getCommodityStatusCode(),
					commodity1.getCommodityStatusCode());

			/** Delete Commodity **/
			Commodity commodity3 = null;
			commodityDao.delete(commodity2);
			commodity3 = commodityDao
					.findCommodity(commodity1.getCommodityId());
			assertNull(commodity3);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
