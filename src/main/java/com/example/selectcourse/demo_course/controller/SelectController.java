package com.example.selectcourse.demo_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.selectcourse.demo_course.repository.SelectcourseDao;
import com.example.selectcourse.demo_course.service.ifs.SelectcourseService;
import com.example.selectcourse.demo_course.vo.SelectRequest;
import com.example.selectcourse.demo_course.vo.SelectResponse;

@RestController
public class SelectController {
	
	@Autowired
	private SelectcourseService selectcourseService;
	
	@Autowired
	private SelectcourseDao selectcourseDao;
	
	@PostMapping("/selectclass")
	public SelectResponse selectclass(@RequestBody SelectRequest selectRequest) {
		return selectcourseService.selectclass(selectRequest);
	}
	
	@PostMapping("/deleteselectclass")
	public SelectResponse deleteselectclass(@RequestBody SelectRequest selectRequest) {
		return selectcourseService.deleteselectclass(selectRequest);
	}
}
