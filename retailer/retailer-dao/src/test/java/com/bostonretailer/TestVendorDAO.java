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

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.AuthStatusCode;
import com.bostonretailer.retailercommon.Commodity;
import com.bostonretailer.retailercommon.Vendor;
import com.bostonretailer.retailerdao.AddressDao;
import com.bostonretailer.retailerdao.CommodityDao;
import com.bostonretailer.retailerdao.VendorDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */
@Transactional
public class TestVendorDAO extends TestCase {

	@Test
	public void testVendorDao() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		AddressDao addressDao = (AddressDao) appContext.getBean("addressDao");
		CommodityDao commodityDao = (CommodityDao) appContext
				.getBean("commodityDao");
		VendorDao vendorDao = (VendorDao) appContext.getBean("vendorDao");

		try {
			/** Setup Init **/
			Address address = new Address();
			address.setAddressLine1("135 Clinton Street");
			address.setAddressLine2("Newton Crossing");
			address.setCity("New York");
			address.setCountry("USA");
			address.setZipCode(1L);
			addressDao.save(address);

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

			/** Insert **/
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
			vendor.getCommodities().add(commodity);
			vendorDao.save(vendor);

			/** Find Address **/
			Vendor vendor1;
			vendor1 = vendorDao.findVendor(vendor.getVendorId());
			assertNotNull(vendor1);
			assertEquals(address.getAddressId(), vendor1.getBusinessAddress()
					.getAddressId());
			assertEquals(vendor.getCommodities().size(), vendor1
					.getCommodities().size());

			/** Update Address **/
			vendor1.setDisplayName("Adidas England");
			vendor1.getCommodities().add(commodity1);
			vendor1.setVendorAuthStatusCode(AuthStatusCode.APPROVED);
			vendorDao.update(vendor1);

			Vendor vendor2;
			vendor2 = vendorDao.findVendor(vendor.getVendorId());
			assertNotNull(vendor2);
			assertEquals(vendor2.getDisplayName(), vendor1.getDisplayName());
			assertEquals(vendor2.getVendorAuthStatusCode(),
					vendor1.getVendorAuthStatusCode());
			assertEquals(vendor1.getCommodities().size(), vendor2
					.getCommodities().size());

			/** Delete Address **/
			vendorDao.delete(vendor2);
			vendor = vendorDao.findVendor(vendor.getVendorId());
			assertNull(vendor);

			/** Setup Destroy **/
			addressDao.delete(address);
		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
