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

import com.bostonretailer.retailercommon.CustomerPaymentOption;
import com.bostonretailer.retailercommon.RefPaymentMethod;
import com.bostonretailer.retailerdao.CustomerPaymentOptionDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestCustomerPaymentOptionDAO extends TestCase {
	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");
		CustomerPaymentOptionDao customerPaymentOptionDao = (CustomerPaymentOptionDao) appContext
				.getBean("customerPaymentOptionDao");

		try {
			/** Insert Customer Payment Option **/
			CustomerPaymentOption customerPaymentOption = new CustomerPaymentOption();
			customerPaymentOption.setCustomerId(1L);
			customerPaymentOption
					.setPaymentMethod(RefPaymentMethod.CREDIT_CARD);
			customerPaymentOption.setCardNumber("1234567890");
			customerPaymentOption
					.setPaymentMethodDetails("This is a credit card");
			customerPaymentOptionDao.save(customerPaymentOption);

			/** Find Customer Payment Option **/
			CustomerPaymentOption customerPaymentOption1;
			customerPaymentOption1 = customerPaymentOptionDao
					.findCustomerPaymentOption(1L);
			assertNotNull(customerPaymentOption1);

			/** Update Customer Payment Option **/
			customerPaymentOption1.setCardNumber("0987654321");
			customerPaymentOptionDao.update(customerPaymentOption1);

			CustomerPaymentOption customerPaymentOption2;
			customerPaymentOption2 = customerPaymentOptionDao
					.findCustomerPaymentOption(1L);
			assertEquals(customerPaymentOption2.getCardNumber(),
					customerPaymentOption1.getCardNumber());

			/** Delete Customer Payment Option **/
			CustomerPaymentOption customerPaymentOption3 = null;
			customerPaymentOptionDao.delete(customerPaymentOption2);
			customerPaymentOption3 = customerPaymentOptionDao
					.findCustomerPaymentOption(1L);
			assertNull(customerPaymentOption3);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}
}
