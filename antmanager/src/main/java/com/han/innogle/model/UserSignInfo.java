package com.han.innogle.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class UserSignInfo {

	private String username;
	
	private String password;
	
	private String password2;
	
	private String userconfirmquestion;
	
	private String userconfirmanswer;
}
