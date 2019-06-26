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
	private int resSingle;

	// 编程分数
	@Column(name = "resProgram")
	private int resProgram;

	// 总分
	@Column(name = "resTotal")
	private int resTotal;

	public StuResult() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the stuId
	 */
	public String getStuId() {
		return stuId;
	}

	/**
	 * @param stuId the stuId to set
	 */
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the resSingle
	 */
	public int getResSingle() {
		return resSingle;
	}

	/**
	 * @param resSingle the resSingle to set
	 */
	public void setResSingle(int resSingle) {
		this.resSingle = resSingle;
	}

	/**
	 * @return the resProgram
	 */
	public int getResProgram() {
		return resProgram;
	}

	/**
	 * @param resProgram the resProgram to set
	 */
	public void setResProgram(int resProgram) {
		this.resProgram = resProgram;
	}

	/**
	 * @return the resTotal
	 */
	public int getResTotal() {
		return resTotal;
	}

	/**
	 * @param resTotal the resTotal to set
	 */
	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StuResult [id=" + id + ", stuId=" + stuId + ", name=" + name + ", resSingle=" + resSingle
				+ ", resProgram=" + resProgram + ", resTotal=" + resTotal + "]";
	}
	
	
}
	

	