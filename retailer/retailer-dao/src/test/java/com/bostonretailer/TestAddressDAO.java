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
import com.bostonretailer.retailerdao.AddressDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */
@Transactional
public class TestAddressDAO extends TestCase {

	@Test
	public void testAddressDAO() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		AddressDao addressDao = (AddressDao) appContext.getBean("addressDao");

		try {
			/** Insert **/
			Address address = new Address();
			address.setAddressLine1("120 Clinton Street");
			address.setAddressLine2("Newton Crossing");
			address.setCity("New York");
			address.setCountry("USA");
			address.setZipCode(1L);
			addressDao.save(address);

			Long addressId = address.getAddressId();

			/** Find Address **/
			Address address1;
			address1 = addressDao.findAddress(addressId);
			assertNotNull(address1);

			/** Update Address **/
			address1.setCountry("England");
			addressDao.update(address1);

			Address address2;
			address2 = addressDao.findAddress(addressId);
			assertEquals(address2.getCountry(), address1.getCountry());

			/** Delete Address **/
			addressDao.delete(address2);
			address = addressDao.findAddress(addressId);
			assertNull(address);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}

}
