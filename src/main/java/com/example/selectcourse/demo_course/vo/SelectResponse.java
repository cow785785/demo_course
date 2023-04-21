package com.example.selectcourse.demo_course.vo;

import java.util.List;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.Selectcourse;
import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectResponse {
	private Integer studentid;

	private Integer classid;
	
	private String classname;
	
	@JsonProperty("select_info")
	private Selectcourse selectcourse;
	@JsonProperty("select_info_list")
	private List<Selectcourse> selectcoursesList;
	
//	@JsonProperty("student_info")
//	private List<StudentSystem> studentSystems;
//	@JsonProperty("class_info")
//	private List<ClassSystem> classSystems;
	
	private String message;

	public SelectResponse() {
		
	}
	
	
	
	public SelectResponse(Integer studentid, Integer classid, String classname, String message) {
		this.studentid = studentid;
		this.classid = classid;
		this.classname = classname;
		this.message = message;
	}




	public SelectResponse(String classname, String message) {
		this.classname = classname;
		this.message = message;
	}



	public SelectResponse(Integer studentid, Integer classid,String message) {
		this.studentid = studentid;
		this.classid = classid;
		this.message = message;
	}
	
	

	public SelectResponse(Integer studentid, Integer classid) {
		this.studentid = studentid;
		this.classid = classid;
	}

	public SelectResponse(Integer studentid, String message) {
		this.studentid = studentid;
		this.message = message;
	}
	
	

//	public SelectResponse(List<StudentSystem> studentSystems, String message) {
//		this.studentSystems = studentSystems;
//		this.message = message;
//	}
//
//	
//	public SelectResponse(List<ClassSystem> classSystems, Integer classid, String message) {
//		this.classSystems = classSystems;
//		this.classid = classid;
//		this.message = message;
//	}



	public SelectResponse(Integer studentid, Integer classid, String classname, Selectcourse selectcourse,
			List<Selectcourse> selectcoursesList, String message) {
		this.studentid = studentid;
		this.classid = classid;
		this.classname = classname;
		this.selectcourse = selectcourse;
		this.selectcoursesList = selectcoursesList;
		this.message = message;
	}



	public SelectResponse(Selectcourse selectcourse, List<Selectcourse> selectcoursesList) {
		this.selectcourse = selectcourse;
		this.selectcoursesList = selectcoursesList;
	}



	public SelectResponse(List<Selectcourse> selectcoursesList, String message) {
		this.selectcoursesList = selectcoursesList;
		this.message = message;
	}



	public SelectResponse(Selectcourse selectcourse, String message) {
		this.selectcourse = selectcourse;
		this.message = message;
	}



	public SelectResponse(String message) {
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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



//	public List<StudentSystem> getStudentSystems() {
//		return studentSystems;
//	}
//
//
//
//	public void setStudentSystems(List<StudentSystem> studentSystems) {
//		this.studentSystems = studentSystems;
//	}
//
//
//
//	public List<ClassSystem> getClassSystems() {
//		return classSystems;
//	}
//
//
//
//	public void setClassSystems(List<ClassSystem> classSystems) {
//		this.classSystems = classSystems;
//	}
//	
	
}
