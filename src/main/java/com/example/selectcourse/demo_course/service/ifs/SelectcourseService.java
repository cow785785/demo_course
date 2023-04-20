package com.example.selectcourse.demo_course.service.ifs;


import com.example.selectcourse.demo_course.vo.SelectRequest;
import com.example.selectcourse.demo_course.vo.SelectResponse;

public interface SelectcourseService {
	public SelectResponse selectclass(SelectRequest selectRequest);//選課
	
	public SelectResponse deleteselectclass(SelectRequest selectRequest);//退選
	
//	public boolean checkCourseSelection(int studentId, List<ClassSystem> selectedCourses);//檢查學分上限
	
}
