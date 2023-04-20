package com.example.selectcourse.demo_course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Selectcourse {

	@Column(name="studentid")
	private Integer studentid;
	
	@Column(name="classid")
	private Integer classid;
	@Id
	@Column(name="classname")
	private String classname;
	
	

	public Selectcourse() {

	}
	
	

	public Selectcourse(Integer studentid, Integer classid, String classname) {
		this.studentid = studentid;
		this.classid = classid;
		this.classname = classname;
	}



	public Selectcourse(Integer studentid, Integer classid) {
		this.studentid = studentid;
		this.classid = classid;
	}


	public Integer getStudentid() {
		return studentid;
	}


	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}


	public Integer getClassid() {
		return classid;
	}


	public void setClassid(Integer classid) {
		this.classid = classid;
	}



	public String getClassname() {
		return classname;
	}



	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
	
	
}
