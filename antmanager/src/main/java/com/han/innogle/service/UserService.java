package com.han.innogle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.innogle.dao.UserDao;
import com.han.innogle.model.Authorities;
import com.han.innogle.model.User;
import com.han.innogle.model.UserSignInfo;

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
		if(userDao.idchk(username).size()==0) {
			return 0;
		}else {
			return 1;
		}
		// TODO Auto-generated method stub
	}

	

	public boolean userconfirmchk(String username) {
		// TODO Auto-generated method stub
		User user=userDao.getUserByName(username);
		if(user.getUserconfirmanswer()==null) {return false;}
		else return true;
	}

	public boolean answerchk(String username,String userconfirmanswer) {//인자는 입력창에 있는거임
		System.out.println("answerchk");
		System.out.println(username);
		System.out.println(username);
		System.out.println(userconfirmanswer);
		User user=userDao.getUserByName(username);
		// TODO Auto-generated method stub
		return user.getUserconfirmanswer().equals(userconfirmanswer);
	}
	
	public boolean updateUserpw(UserSignInfo userSignInfo) {
		if(userSignInfo.getPassword().equals(userSignInfo.getPassword2())){
			User user=new User();
			String pwd ="{noop}"+ userSignInfo.getPassword();
			user.setUsername(userSignInfo.getUsername());
			user.setPassword(pwd);
			user.setEnabled(true);
			user.setUserconfirmquestion(userSignInfo.getUserconfirmquestion());
			user.setUserconfirmanswer(userSignInfo.getUserconfirmanswer());
			userDao.updateUser(user);
			return true;
		}else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	
	public boolean signup(UserSignInfo userSignInfo) {
		if(userSignInfo.getPassword().equals(userSignInfo.getPassword2())){
			User user=new User();
			String pwd ="{noop}"+ userSignInfo.getPassword();
			user.setUsername(userSignInfo.getUsername());
			user.setPassword(pwd);
			user.setEnabled(true);
			user.setUserconfirmquestion(userSignInfo.getUserconfirmquestion());
			user.setUserconfirmanswer(userSignInfo.getUserconfirmanswer());
			Authorities userauth=new Authorities();
			userauth.setUsername(user.getUsername());
			userauth.setAuthority("ROLE_USER");
			userDao.signup(user,userauth);
			return true;
		}else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
}
