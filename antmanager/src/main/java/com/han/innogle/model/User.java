package com.han.innogle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="username", nullable=false)
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	@Column(name="userconfirmquestion")
	private String userconfirmquestion;
	@Column(name="userconfirmanswer")
	private String userconfirmanswer;
}
