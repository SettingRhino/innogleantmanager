package com.han.innogle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.han.innogle.model.Customer;
import com.han.innogle.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//현재 있는 손님리스트 보여주기
	@RequestMapping("/customers")
	public String getCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers",customers);
		
		
		return "customer"; 
	}

	@RequestMapping(value = "/customers/addCustomer", method = RequestMethod.GET)
	public String addCustomer(Model model) {

		Customer customers = new Customer();

		model.addAttribute("customers", customers);

		return "addCustomer";
	}

	@RequestMapping(value = "/customers/addCustomerAfter", method = RequestMethod.GET)
	public String addCustomerPost(@Valid Customer customer, BindingResult result, HttpServletRequest request) {

		if(result.hasErrors()) {
			System.out.println("===Web From data has some errors===");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "addCustomer";
		}	
		
		customerService.addCustomer(customer);

		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers/deleteCustomer/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int id, HttpServletRequest request) {

		Customer customer = customerService.getCustomerById(id);

		customerService.deleteCustomer(customer);

		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers/updateCustomer/{id}", method = RequestMethod.GET)
	public String updateCustomer(@PathVariable int id, Model model) {

		Customer customer = customerService.getCustomerById(id);

		model.addAttribute("customer", customer);

		return "updateCustomer";

	}

	@RequestMapping(value = "/customers/updateCustomerAfter", method = RequestMethod.GET)
	public String updateCustomerPost(@Valid Customer customer, BindingResult result, HttpServletRequest request) {

		
		if(result.hasErrors()) {
			System.out.println("===Web From data has some errors===");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "updateCustomer";
		}

		customerService.updateCustomer(customer);

		return "redirect:/customers";
	}
	
	@RequestMapping("/viewCustomer/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		
		return "viewCustomer";
	}
	
}
