package com.bostonretailer;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailerservices.CustomerBOService;

/**
 * Unit test for simple App.
 */
public class TestCustomerBOServices extends TestCase {

	@Test
	public void testCustomerBOServices() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-services-application-context.xml");
		CustomerBOService customerBO = (CustomerBOService) appContext
				.getBean("customerBOService");

		try {
			/** Insert Customer **/
			Customer customer = new Customer();
			customer.setGender("M");
			customer.setFirstName("Bruce");
			customer.setLastName("Nicholas");
			customer.setEmailAddress("newton");
			customer.setPassword("newton");
			customer.setPhoneNumber("newton");
			
			/*
			 * customer.setAddressLine1("Doe"); customer.setAddressLine2("Doe");
			 * customer.setCity("Doe"); customer.setCountry("Doe");
			 * customer.setZipCode(2L);
			 */
			customerBO.createCustomer(customer);

			/** Find Customer **/
			Customer customer1;
			customer1 = customerBO.findByCustomerId(3L);
			assertNotNull(customer1);

			/** Update Customer **/
			/* customer1.setCountry("England"); */
			customerBO.updateCustomer(customer1);

			Customer customer2;
			customer2 = customerBO.findByCustomerId(3L);
			/* assertEquals(customer2.getCountry(), customer1.getCountry()); */

			/** Delete Customer **/
			Customer customer3 = null;
			customerBO.deleteCustomer(customer2);
			customer3 = customerBO.findByCustomerId(3L);
			assertNull(customer3);
			
		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}