package com.lut.lwn.onlineexam.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Student")
public class Student {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	// 身份证号
	@Column(name = "stuCardNo")
	private String stuCardNo;
	// 准考证号
	@Column(name = "stuId")
	private String stuId;

	public Student() {
		super();
	}

	public Student(String name, String stuCardNo, String stuId) {
		super();
		this.name = name;
		this.stuCardNo = stuCardNo;
		this.stuId = stuId;
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

	public String getStuCardNo() {
		return stuCardNo;
	}

	public void setStuCardNo(String stuCardNo) {
		this.stuCardNo = stuCardNo;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stuCardNo=" + stuCardNo + ", stuId=" + stuId + "]";
	}

}
