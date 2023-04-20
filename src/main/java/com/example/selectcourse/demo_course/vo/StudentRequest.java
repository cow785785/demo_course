package com.example.selectcourse.demo_course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;


public class StudentRequest {

	private Integer id;

	private String studentname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	
}

