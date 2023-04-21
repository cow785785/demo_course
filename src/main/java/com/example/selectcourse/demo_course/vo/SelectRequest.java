package com.example.selectcourse.demo_course.vo;

import java.util.List;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.Selectcourse;
import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectRequest {
	private Integer studentid;
	
	private Integer classid;
	
	private String classname;
	@JsonProperty("select_info")
	private Selectcourse selectcourse;
	@JsonProperty("select_info_list")
	private List<Selectcourse> selectcoursesList;


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

	public Selectcourse getSelectcourse() {
		return selectcourse;
	}

	public void setSelectcourse(Selectcourse selectcourse) {
		this.selectcourse = selectcourse;
	}

	public List<Selectcourse> getSelectcoursesList() {
		return selectcoursesList;
	}

	public void setSelectcoursesList(List<Selectcourse> selectcoursesList) {
		this.selectcoursesList = selectcoursesList;
	}

	
}
