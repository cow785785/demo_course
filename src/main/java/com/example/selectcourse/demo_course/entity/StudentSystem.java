package com.example.selectcourse.demo_course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentSystem {
	@Id
	@Column(name = "studentid")
	private Integer id;
	
	@Column(name = "studentname")
	private String studentname;
	


	public StudentSystem() {
		
	}
	

	public StudentSystem(Integer id, String studentname) {
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


//	public ClassSystem getClassSystem() {
//		return classSystem;
//	}
//
//
//	public void setClassSystem(ClassSystem classSystem) {
//		this.classSystem = classSystem;
//	}


//	public List<ClassSystem> getClassSystems() {
//		return classSystems;
//	}
//
//
//	public void setClassSystems(List<ClassSystem> classSystems) {
//		this.classSystems = classSystems;
//	}
	
	
}

