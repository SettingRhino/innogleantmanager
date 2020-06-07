package com.han.innogle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.innogle.dao.UserDao;
import com.han.innogle.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(username);
	} 
	
	public void addUser(User user) {
		userDao.addUser(user);
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		 userDao.updateUser(user);
	}

	public int idchk(String username) {
		return userDao.idchk(username);
		// TODO Auto-generated method stub
	}

	public void signup(User user) {
		userDao.signup(user);
		// TODO Auto-generated method stub
		
	}
}
