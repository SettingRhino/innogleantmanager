package com.han.innogle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.han.innogle.model.Customer;

@Repository
@Transactional
public class CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Customer getCustomerById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);

		return customer;

	}

	public List<Customer> getCustomers(String name) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from Customer where user=:username";

		Query<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("username", name);
		List<Customer> customerList = query.getResultList();

		return customerList;

	}

	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		session.flush();
	}

	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		session.flush();
	}

	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		session.flush();
	}

	/*
	 * public boolean addProduct(Product product) {
	 * 
	 * 
	 * int id = product.getId(); String name = product.getName(); String category =
	 * product.getCategory(); int price = product.getPrice(); String manufacturer =
	 * product.getManufacturer(); int unitInStock = product.getUnitInStock(); String
	 * description = product.getDescription();
	 * 
	 * String sqlStatement =
	 * "insert into product (id, name, category, price, manufacturer, unitInStock, description)"
	 * + " values (?,?,?,?,?,?,?)";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { id, name, category,
	 * price, manufacturer, unitInStock, description }) == 1);
	 * 
	 * }
	 */

	/*
	 * public boolean deleteProduct(int id) {
	 * 
	 * 
	 * String sqlStatement = "delete from product where id=?";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	 * 
	 * }
	 */
	/*
	 * public boolean updateProduct(Product product) {
	 * 
	 * Session session = sessionFactory.getCurrentSession();
	 * session.saveOrUpdate(product); session.flush();
	 * 
	 * int id = product.getId(); String name = product.getName(); String category =
	 * product.getCategory(); int price = product.getPrice(); String manufacturer =
	 * product.getManufacturer(); int unitInStock = product.getUnitInStock(); String
	 * description = product.getDescription();
	 * 
	 * String sqlStatement =
	 * "update product set name=?, category=?, price=?, manufacturer=?, unitInStock=?, description=?"
	 * + " where id=?";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { name, category,
	 * price, manufacturer, unitInStock, description,id }) == 1);
	 * 
	 * 
	 * }
	 */
}
