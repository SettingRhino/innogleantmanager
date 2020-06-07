package com.han.innogle.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="authorities")
public class Authorities {
	@Id
	@Column(name="username", nullable=false)
	private String username;
	@Column(name="authority", nullable=false)
	private String authority;
	
}
