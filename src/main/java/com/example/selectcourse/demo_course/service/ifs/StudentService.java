package com.example.selectcourse.demo_course.service.ifs;

import java.util.List;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.example.selectcourse.demo_course.vo.StudentRequest;
import com.example.selectcourse.demo_course.vo.StudentResponse;


public interface StudentService {
	public StudentResponse addStudent(StudentRequest studentRequest);

	public List<StudentSystem> getAllStudent();

	public StudentResponse getStudent(StudentRequest studentRequest);

	public StudentResponse updateStudent(StudentRequest studentRequest);

	public StudentResponse deleteStudent(StudentRequest studentRequest);
	
//	public StudentResponse registerCourse(int studentid, int courseid);
	
//	public List<ClassSystem> findSelectedCoursesByStudentId();
	


}