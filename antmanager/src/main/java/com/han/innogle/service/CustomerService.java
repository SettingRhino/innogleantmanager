package com.han.innogle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.han.innogle.dao.CustomerDao;
import com.han.innogle.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
	
	public List<Customer> getCustomers(String name) {
		return customerDao.getCustomers(name);
	}
	
	public void addCustomer(Customer customer, Authentication auth) {
		customer.setUser(auth.getName());
		customerDao.addCustomer(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	public void updateCustomer(Customer customer, Authentication auth) {
		customer.setUser(auth.getName());
		customerDao.updateCustomer(customer);
	}
}
