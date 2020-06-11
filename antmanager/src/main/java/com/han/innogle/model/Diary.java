package com.han.innogle.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
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
@Table(name="dairytable")
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	@NotEmpty(message="제목은 꼭 입력해주세요!")
	@Column(name="title", nullable=false)
	private String title;
	@Column(name="user", nullable=false)
	private String user;
	@Column(name="contents", nullable=true)
	private String contents;
	@Column(name="description", nullable=true)
	private String description;
	@Column(name="date", nullable=true)
	private String date;
}
