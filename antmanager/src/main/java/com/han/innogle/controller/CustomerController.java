package com.han.innogle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.han.innogle.model.Customer;
import com.han.innogle.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	// 현재 있는 손님리스트 보여주기
	@RequestMapping("/customers")
	public String getCustomers(Model model, Authentication auth) {
		if (!auth.isAuthenticated()) {
			return "redirect:/login";
		} else {
			List<Customer> customers = customerService.getCustomers(auth.getName());

			model.addAttribute("customers", customers);

			return "customer";
		}
	}

	
	@RequestMapping(value = "/customers/addCustomer", method = RequestMethod.GET)
	public String addCustomer(Authentication auth,Model model) {

		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			Customer customers = new Customer();

			model.addAttribute("customers", customers);
			
			return "addCustomer";
		}
		
		/*
		Customer customers = new Customer();

		model.addAttribute("customers", customers);

		return "addCustomer";
		*/
	}

	@RequestMapping(value = "/customers/addCustomerAfter", method = RequestMethod.POST)
	public String addCustomerPost(@Valid Customer customer, BindingResult result, Authentication auth) {

		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(result.hasErrors()) {
				System.out.println("====Web Form data does not validdated ====");
				List<ObjectError> errors=result.getAllErrors();
				for(ObjectError error:errors) {
					System.out.println(error.getDefaultMessage());
				}
				return "addCustomer";
			}

			customerService.updateCustomer(customer, auth);

			return "redirect:/customers";
		}
	}
	

	@RequestMapping(value = "/customers/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value="id")String id,Authentication auth) {
		
		String name=auth.getName();
		Customer customer = customerService.getCustomerById(Integer.parseInt(id));
		if(customer.getUser().equals(name)) {//현재 접속자와 글주인이 같다면
			customerService.deleteCustomer(customer);
		}
		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers/updateCustomer", method = RequestMethod.GET)
	public String updateCustomer(@RequestParam(value="user",required=false)String user ,
			@RequestParam(value="id",required=false)String id,Authentication auth,Model model) {

		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(user!=null&&id!=null) {
				Customer customer = customerService.getCustomerById(Integer.parseInt(id));
				model.addAttribute("customer", customer);
			}
			return "updateCustomer";
		}

	}

	@RequestMapping(value = "/customers/updateCustomerAfter", method = RequestMethod.POST)
	public String updateCustomerPost(@Valid Customer customer, BindingResult result, Authentication auth) {

		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(result.hasErrors()) {
				System.out.println("====Web Form data does not validdated ====");
				List<ObjectError> errors=result.getAllErrors();
				for(ObjectError error:errors) {
					System.out.println(error.getDefaultMessage());
				}
				return "updateCustomer";
			}

			customerService.updateCustomer(customer, auth);

			return "redirect:/customers";
		}
	}

	@RequestMapping("/viewCustomer")
	public String viewProduct(@RequestParam(value="user")String user,
			@RequestParam(value="id")String id,Authentication auth, Model model) {

		if(!auth.isAuthenticated()) {
			return "redirect:/login";
		}
		else {
			if(auth.getName().equals(user)) {
				//같다. 사용자 맞음
				Customer customer = customerService.getCustomerById(Integer.parseInt(id));
				System.out.println(customer.toString());
				model.addAttribute("customer", customer);
				return "viewCustomer";
			}
			else {
				//내보내기 일단 홈으로
				return "redirect:/";
			}
		}
	}

}
