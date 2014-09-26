/**
 * 
 */
package com.bostonretailer.retailercontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bostonretailer.retailerservices.AdminBOService;

/**
 * @author Rakesh_Viswanathan
 * 
 */

public class HomeController implements Controller {
	private AdminBOService adminBOService;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("products", this.adminBOService.getAllProducts());

		return new ModelAndView("home", "model", myModel);
	}

	public void setAdminBOService(AdminBOService adminBOService) {
		this.adminBOService = adminBOService;
	}
}
