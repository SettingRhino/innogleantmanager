package com.han.innogle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}
}
