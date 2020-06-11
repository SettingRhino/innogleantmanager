package com.han.innogle.dao;

import java.util.List;

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
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public User getUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from User where username=:username";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("username", username);
		List<User> users=query.getResultList();
		
		// TODO Auto-generated method stub
		return users.get(0);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.flush();
	}

//바꾸기
	public 	List<User> idchk(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from User where username=:username";
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("username", username);
		List<User> users=query.getResultList();
		System.out.println("존재여부"+users.size());
		return users;
		
		// TODO Auto-generated method stub

	}

	public void signup(User user,Authorities userauth) {
		//등록하자.
		//{noop}붙이기
		//System.out.println(pwd);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.saveOrUpdate(userauth);
		session.flush();
		// TODO Auto-generated method stub
		
	}

	
}