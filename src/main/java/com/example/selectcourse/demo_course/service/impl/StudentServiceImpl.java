package com.example.selectcourse.demo_course.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.Selectcourse;
import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.example.selectcourse.demo_course.repository.ClassDao;
import com.example.selectcourse.demo_course.repository.SelectcourseDao;
import com.example.selectcourse.demo_course.repository.StudentDao;
import com.example.selectcourse.demo_course.service.ifs.StudentService;
import com.example.selectcourse.demo_course.vo.StudentRequest;
import com.example.selectcourse.demo_course.vo.StudentResponse;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ClassDao classDao;
	
	@Autowired
	private SelectcourseDao selectcourseDao;
	 
	
	@Override
	public StudentResponse addStudent(StudentRequest studentRequest) {
		if (studentRequest.getId()==null || !StringUtils.hasText(studentRequest.getStudentname())) {
			return new StudentResponse("失敗!格式錯誤");
		}
		if (studentDao.existsById(studentRequest.getId())) {
			return new StudentResponse(studentRequest.getId(),"帳號或ID已存在");
		}

		StudentSystem studentSystem = new StudentSystem(studentRequest.getId(), studentRequest.getStudentname());
		studentDao.save(studentSystem);
		return new StudentResponse(studentRequest.getId(),studentRequest.getStudentname(),"註冊成功");
	}

	@Override
	public List<StudentSystem> getAllStudent() {
		
		return studentDao.findAll();
	}

	@Override
	public StudentResponse getStudent(StudentRequest studentRequest) {
		if (studentRequest.getId()==null || !StringUtils.hasText(studentRequest.getStudentname())) {
			return new StudentResponse("失敗!不得為空");
		}
		
		Optional<StudentSystem> optional=studentDao.findById(studentRequest.getId());
		if(!optional.isPresent()) {
			return new StudentResponse("ID或NAME不得為空");
		}
		
		StudentSystem studentSystem=optional.get();
		return new StudentResponse(studentRequest.getId(),studentRequest.getStudentname());
	}

	@Override
	public StudentResponse updateStudent(StudentRequest studentRequest) {
		if (studentRequest.getId()==null || !StringUtils.hasText(studentRequest.getStudentname())) {
			return new StudentResponse("失敗!格式錯誤");
		}
		
		Optional<StudentSystem> optional=studentDao.findById(studentRequest.getId());
		if(!optional.isPresent()) {
			return new StudentResponse(studentRequest.getId(),"ID不存在");
		}
		StudentSystem studentSystem = optional.get();
		studentSystem.setId(studentRequest.getId());
		studentSystem.setStudentname(studentRequest.getStudentname());
		studentDao.save(studentSystem);
		return new StudentResponse(studentRequest.getId(),studentRequest.getStudentname(),"更新成功");
	}

	@Override
	public StudentResponse deleteStudent(StudentRequest studentRequest) {
		if (studentRequest.getId() == null) {
	        return new StudentResponse("學號不得為空");
	    }
		
		// 檢查學生是否存在
	    Optional<StudentSystem> optionalStudent = studentDao.findById(studentRequest.getId());
	    if (!optionalStudent.isPresent()) {
	        return new StudentResponse(studentRequest.getId(), "學生不存在");
	    }
		
	    List<Selectcourse> list=selectcourseDao.findByStudentid(studentRequest.getId());
//	    sOptional.get();
	    
	    selectcourseDao.deleteAll(list);
	    // 刪除學生
	    StudentSystem student = optionalStudent.get();
	    studentDao.delete(student);

		return new StudentResponse("刪除成功");
	}

//	@Override
//	public List<ClassSystem> findSelectedCoursesByStudentId() {
//		return studentDao.findSelectedCoursesByStudentId();
//	}

//	@Override
//	public StudentResponse registerCourse(int studentid, int courseid) {
//		Optional<StudentSystem> studentSystem=studentDao.findById(studentid);
//		
//		Optional<ClassSystem> classSystem=classDao.findById(courseid);
//		
//		if(studentSystem == null || classSystem == null) {
//	        return new StudentResponse("學生ID或課程ID不能為空");
//	    }
//	    if(studentSystem.get().getClassSystem().contains(classSystem)) {
//	        return new StudentResponse("已選擇這個課程");
//	    }
//	    studentSystem.get().getClassSystems().add(classSystem.get());
//	    studentDao.save(studentSystem.get());
//		
//		return new StudentResponse();
//	}

}
