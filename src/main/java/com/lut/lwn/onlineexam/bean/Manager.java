package com.lut.lwn.onlineexam.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_manager")
public class Manager {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cardNo")
	private String cardNo;
	
	@Column(name="password")
	private String password;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, String cardNo, String password) {
		super();
		this.name = name;
		this.cardNo = cardNo;
		this.password = password;
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

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", cardNo=" + cardNo + ", password=" + password + "]";
	}
	
	
}
