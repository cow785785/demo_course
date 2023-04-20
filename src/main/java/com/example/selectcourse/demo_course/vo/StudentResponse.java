package com.example.selectcourse.demo_course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
	private Integer id;

	private String studentname;
	
	private String message;

	public StudentResponse() {

	}

	public StudentResponse(Integer id, String studentname,String message) {
		this.id = id;
		this.studentname = studentname;
		this.message=message;
	}

	public StudentResponse(String message) {
		this.message = message;
	}

	public StudentResponse(String studentname, String message) {
		this.studentname = studentname;
		this.message = message;
	}

	public StudentResponse(Integer id, String studentname) {
		this.id = id;
		this.studentname = studentname;
	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
