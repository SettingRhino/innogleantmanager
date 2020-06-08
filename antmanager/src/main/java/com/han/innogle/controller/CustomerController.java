package com.han.innogle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.han.innogle.model.Customer;
import com.han.innogle.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String getCustomers(Model model) {
		/*
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers",customers);
		*/
		
		return "customer";  //view�쓽 logical name
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
