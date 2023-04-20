package com.example.selectcourse.demo_course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.example.selectcourse.demo_course.repository.StudentDao;
import com.example.selectcourse.demo_course.service.ifs.StudentService;
import com.example.selectcourse.demo_course.vo.StudentRequest;
import com.example.selectcourse.demo_course.vo.StudentResponse;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentervice;
	
	@Autowired
	private StudentDao studentDao;
	
	
	@PostMapping("/addStudent")
	public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
		return studentervice.addStudent(studentRequest);
	}
	@PostMapping("/getAllStudent")
	public List<StudentSystem> getAllStudent(){
		return studentDao.findAll();
	}
	@PostMapping("/getStudent")
	public StudentResponse getStudent(@RequestBody StudentRequest studentRequest) {
		return studentervice.getStudent(studentRequest);
	}
	@PostMapping("/updateStudent")
	public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest) {
		return studentervice.updateStudent(studentRequest);
	}
	@PostMapping("/deleteStudent")
	public StudentResponse deleteStudent(@RequestBody StudentRequest studentRequest) {
		return studentervice.deleteStudent(studentRequest);
	}
}

