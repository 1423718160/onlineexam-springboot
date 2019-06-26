package com.lut.lwn.onlineexam.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_examPage")
public class ExamPage {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "stuId")
	private String stuId;

	@Column(name = "name")
	private String name;

	@Column(name = "question")
	private String question;

	@Column(name = "optionA")
	private String optionA;

	@Column(name = "optionB")
	private String optionB;

	@Column(name = "optionC")
	private String optionC;

	@Column(name = "optionD")
	private String optionD;

	@Column(name = "answer")
	private String answer;
	
	@Column(name = "stuAnswer")
	private String stuAnswer;

	@Column(name = "subTime")
	private Date subTime;

	// 分值
	@Column(name = "score")
	private String score;

	public ExamPage() {
		super();
	}

	public ExamPage(String stuId, String name, String question, String optionA, String optionB, String optionC,
			String optionD, String answer, Date subTime, String score) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.subTime = subTime;
		this.score = score;
	}

	public String getScore() {
		return score;
	}

	public String getStuAnswer() {
		return stuAnswer;
	}

	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getSubTime() {
		return subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	@Override
	public String toString() {
		return "ExamPage [id=" + id + ", stuId=" + stuId + ", name=" + name + ", question=" + question + ", optionA="
				+ optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", answer="
				+ answer + ", subTime=" + subTime + ", score=" + score + "]";
	}

}
