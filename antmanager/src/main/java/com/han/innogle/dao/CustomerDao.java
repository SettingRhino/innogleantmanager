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

	/*
	 * private JdbcTemplate jdbcTemplate;
	 * 
	 * @Autowired public void setDataSource(DataSource dataSource) { jdbcTemplate =
	 * new JdbcTemplate(dataSource); }
	 */

	public Customer getCustomerById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);

		return customer;

		/*
		 * String sqlStatement = "select * from product where id=?";
		 * 
		 * return jdbcTemplate.queryForObject(sqlStatement, new Object[] {id}, new
		 * RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("unitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product; }
		 * 
		 * });
		 */
	}

	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from Customer";

		Query<Customer> query = session.createQuery(hql, Customer.class);
		List<Customer> customerList = query.getResultList();

		return customerList;

		/*
		 * String sqlStatement = "select * from product";
		 * 
		 * return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("unitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product; }
		 * 
		 * });
		 */
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
