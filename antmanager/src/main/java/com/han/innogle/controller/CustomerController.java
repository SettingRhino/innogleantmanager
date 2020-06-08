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
		
		
		return "customer";  //view�쓽 logical name
	}

	@RequestMapping(value = "/customers/addCustomer", method = RequestMethod.GET)
	public String addProduct(Model model) {

		Customer customers = new Customer();

		model.addAttribute("customers", customers);

		return "addCustomer";
	}

	// web form data -> object(filled with form data)
	@RequestMapping(value = "customers/addCustomer", method = RequestMethod.POST)
	public String addProductPost(@Valid Customer customer, BindingResult result, HttpServletRequest request) {

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
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {

		Customer customer = customerService.getCustomerById(id);

		customerService.deleteCustomer(customer);
//		if (!productService.deleteProduct(id)) 
//			System.out.println("Deleting Product cannot be done");

		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers/updateCustomer/{id}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable int id, Model model) {

		// db�씫�뼱���꽌
		Customer customer = customerService.getCustomerById(id);
		// 紐⑤뜽�뿉 �꽔怨�
		model.addAttribute("customer", customer);
		// jsp�뿉�꽌 洹몃젮以섏꽌 湲곗〈 �궡�슜�씠 �뤌�뿉 �뱾�뼱媛��엳�쓬
		return "updateCustomer";

	}

	@RequestMapping(value = "/customers/updateCustomer", method = RequestMethod.POST)
	public String updateProductPost(@Valid Customer customer, BindingResult result, HttpServletRequest request) {

		
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
	/*
	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) {
		
		Product product = productService.getProductById(productId);
		
		model.addAttribute("product", product);
		
		return "viewProduct";
	}
	*/
}
