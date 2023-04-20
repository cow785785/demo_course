package com.example.selectcourse.demo_course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.repository.ClassDao;
import com.example.selectcourse.demo_course.service.ifs.ClassService;
import com.example.selectcourse.demo_course.vo.ClassRequest;
import com.example.selectcourse.demo_course.vo.ClassResponse;

@RestController
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ClassDao classDao;
	
	@PostMapping("/addClass")
	public ClassResponse addClass(@RequestBody ClassRequest classRequest) {
		return classService.addclass(classRequest);
	}
	
	@PostMapping("/getAllClass")
	public List<ClassSystem> getAllClass(){
		return classDao.findAll();
	}
	
	@PostMapping("/getClass")
	public ClassResponse getClass(@RequestBody ClassRequest classRequest) {
		return classService.getClass(classRequest);
	}
	@PostMapping("/updatemember")
	public ClassResponse updatemember(@RequestBody ClassRequest classRequest) {
		return classService.updatemember(classRequest);
	}
	@PostMapping("/deleteMember")
	public ClassResponse deleteMember(@RequestBody ClassRequest classRequest) {
		return classService.deleteMember(classRequest);
	}
}
