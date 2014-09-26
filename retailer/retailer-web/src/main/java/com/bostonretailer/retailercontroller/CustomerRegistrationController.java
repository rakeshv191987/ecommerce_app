/**
 * 
 */
package com.bostonretailer.retailercontroller;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailerservices.CustomerBOService;

/**
 * @author Rakesh_Viswanathan
 * 
 */
@SuppressWarnings("deprecation")
public class CustomerRegistrationController extends SimpleFormController {
	private CustomerBOService customerBOService;

	public ModelAndView onSubmit(Object command) throws ServletException {

		// Create Address object
		Address address = new Address();
		address.setAddressLine1(((Address) command).getAddressLine1());
		address.setAddressLine2(((Address) command).getAddressLine2());
		address.setCity(((Address) command).getCity());
		address.setCountry(((Address) command).getCountry());
		address.setZipCode(((Address) command).getZipCode());

		// Create Customer object
		Customer customer = new Customer();
		customer.setGender(((Customer) command).getGender());
		customer.setFirstName(((Customer) command).getFirstName());
		customer.setLastName(((Customer) command).getLastName());
		customer.setEmailAddress(((Customer) command).getEmailAddress());
		customer.setPassword(((Customer) command).getPassword());
		customer.setPhoneNumber(((Customer) command).getPhoneNumber());
		customer.setAddress(((Customer) command).getAddress());

		customerBOService.createCustomer(customer);

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	public void setCustomerBOService(CustomerBOService customerBOService) {
		this.customerBOService = customerBOService;
	}

	public CustomerBOService getCustomerBOService() {
		return customerBOService;
	}
}
