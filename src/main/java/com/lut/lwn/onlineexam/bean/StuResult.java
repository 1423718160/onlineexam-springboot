package com.lut.lwn.onlineexam.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stuResult")
public class StuResult {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "stuId")
	private String stuId;
	
	@Column(name = "name")
	private String name;
	// 单选分数
	@Column(name = "resSingle")
	private String resSingle;

	// 编程分数
	@Column(name = "resProgram")
	private String resProgram;

	// 总分
	@Column(name = "resTotal")
	private String resTotal;

	public StuResult() {
		super();
	}

	

	public StuResult(String stuId, String name, String resSingle, String resProgram, String resTotal) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.resSingle = resSingle;
		this.resProgram = resProgram;
		this.resTotal = resTotal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getResSingle() {
		return resSingle;
	}

	public void setResSingle(String resSingle) {
		this.resSingle = resSingle;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getResProgram() {
		return resProgram;
	}

	public void setResProgram(String resProgram) {
		this.resProgram = resProgram;
	}

	public String getResTotal() {
		return resTotal;
	}

	public void setResTotal(String resTotal) {
		this.resTotal = resTotal;
	}

	@Override
	public String toString() {
		return "StuResult [id=" + id + ", stuId=" + stuId + ", resSingle=" + resSingle + ", resProgram=" + resProgram
				+ ", resTotal=" + resTotal + "]";
	}

}
