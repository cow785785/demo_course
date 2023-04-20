package com.example.selectcourse.demo_course.service.impl;

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
import com.example.selectcourse.demo_course.service.ifs.ClassService;
import com.example.selectcourse.demo_course.vo.ClassRequest;
import com.example.selectcourse.demo_course.vo.ClassResponse;


@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;
	
	@Autowired
	private SelectcourseDao selectcourseDao;
	

	@Override
	public ClassResponse addclass(ClassRequest classRequest) {
		if (classRequest.getClassid()==null|| !StringUtils.hasText(classRequest.getClassname())
				|| !StringUtils.hasText(classRequest.getDayOfWeek())||!StringUtils.hasText(classRequest.getStartTime())
				|| !StringUtils.hasText(classRequest.getEndTime()) || classRequest.getCredit()==null) {
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "����!!,�榡���~");
		}

		if (classDao.existsById(classRequest.getClassid())) {
			return new ClassResponse(classRequest.getClassid(), "�ҵ{ID�w�s�b");
		}

		ClassSystem classSystem = new ClassSystem(classRequest.getClassid(), classRequest.getClassname(), classRequest.getDayOfWeek(),classRequest.getStartTime(),classRequest.getEndTime(),classRequest.getCredit());
		classDao.save(classSystem);
		
		

		return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "�s�W�ҵ{���\");
	}

	@Override
	public List<ClassSystem> getAllClass() {

		return classDao.findAll();
	}

	@Override
	public ClassResponse getClass(ClassRequest classRequest) {
		if (classRequest.getClassid()==null && !StringUtils.hasText(classRequest.getClassname())) {
			return new ClassResponse("ID��NAME���o����");
		}
		
		Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
		if(!optional.isPresent()) {  
			return new ClassResponse(classRequest.getClassid(),"ID���s�b");
		 }
		ClassSystem classSystem=optional.get();
		return new ClassResponse(classSystem.getClassid(), classSystem.getClassname(), classSystem.getCredit());
		
	}


	@Override
	public ClassResponse updatemember(ClassRequest classRequest) {
		if (classRequest.getClassid()==null|| !StringUtils.hasText(classRequest.getClassname())
				|| !StringUtils.hasText(classRequest.getDayOfWeek())||!StringUtils.hasText(classRequest.getStartTime())
				|| !StringUtils.hasText(classRequest.getEndTime()) || classRequest.getCredit()==null) {
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "����!!,�榡���~");
		}

	    Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
	    if (!optional.isPresent()) {
	        return new ClassResponse(classRequest.getClassid(), "ID���s�b");
	    }

	    ClassSystem classSystem = optional.get();
	    classSystem.setClassid(classRequest.getClassid());
	    classSystem.setClassname(classRequest.getClassname());
	    classSystem.setDayOfWeek(classRequest.getDayOfWeek());
	    classSystem.setStartTime(classRequest.getStartTime());
	    classSystem.setEndTime(classRequest.getEndTime());
	    classSystem.setCredit(classRequest.getCredit());
	    classDao.save(classSystem);

	    return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), classRequest.getDayOfWeek(),classRequest.getStartTime(),classRequest.getEndTime(),classRequest.getCredit(), "��s���\");
	}

	@Override
	public ClassResponse deleteMember(ClassRequest classRequest) {
		if (classRequest.getClassid()==null|| !StringUtils.hasText(classRequest.getClassname())
				|| !StringUtils.hasText(classRequest.getDayOfWeek())||!StringUtils.hasText(classRequest.getStartTime())
				|| !StringUtils.hasText(classRequest.getEndTime()) || classRequest.getCredit()==null) {
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "����!!,�榡���~");
		}

		    Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
		    if (optional == null) {
		        return new ClassResponse("����R��");
		        }
		    
		    if (!optional.isPresent()) {
		        return new ClassResponse(classRequest.getClassid(), "ID���s�b");
		    }		    		   
		   
		    
		    List<Selectcourse> selectcourses=selectcourseDao.findByClassid(classRequest.getClassid());
		    selectcourseDao.deleteAll(selectcourses);
		    
		    ClassSystem classSystem = optional.get();
		    classDao.delete(classSystem);

		    return new ClassResponse(classRequest.getClassid(),classRequest.getClassname(),"�R�����\");
	}

}
