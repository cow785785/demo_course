package com.example.selectcourse.demo_course.service.ifs;


import com.example.selectcourse.demo_course.vo.SelectRequest;
import com.example.selectcourse.demo_course.vo.SelectResponse;

public interface SelectcourseService {
	public SelectResponse selectclass(SelectRequest selectRequest);//���
	
	public SelectResponse deleteselectclass(SelectRequest selectRequest);//�h��
	
//	public boolean checkCourseSelection(int studentId, List<ClassSystem> selectedCourses);//�ˬd�Ǥ��W��
	
}
