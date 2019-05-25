package com.lut.lwn.onlineexam.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_User")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	// 账号
	@Column(name = "account")
	private String account;
	// 密码
	@Column(name = "password")
	private String password;
	//学生1 教师2
	@Column(name = "type")
	private Long type;
	
	
	public User() {
		super();
	}


	public User(Long id, String name, String account, String password, Long type) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", type="
				+ type + "]";
	}

}
