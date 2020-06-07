package com.han.innogle.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.han.innogle.model.Authorities;
import com.han.innogle.model.User;

@Repository
@Transactional
public class AuthoritiesDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void signup(Authorities userauth) {
		
	}

}
