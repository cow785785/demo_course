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
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "失敗!!,格式錯誤");
		}

		if (classDao.existsById(classRequest.getClassid())) {
			return new ClassResponse(classRequest.getClassid(), "課程ID已存在");
		}

		ClassSystem classSystem = new ClassSystem(classRequest.getClassid(), classRequest.getClassname(), classRequest.getDayOfWeek(),classRequest.getStartTime(),classRequest.getEndTime(),classRequest.getCredit());
		classDao.save(classSystem);
		
		

		return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "新增課程成功");
	}

	@Override
	public List<ClassSystem> getAllClass() {

		return classDao.findAll();
	}

	@Override
	public ClassResponse getClass(ClassRequest classRequest) {
		if (classRequest.getClassid()==null && !StringUtils.hasText(classRequest.getClassname())) {
			return new ClassResponse("ID或NAME不得為空");
		}
		
		Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
		if(!optional.isPresent()) {  
			return new ClassResponse(classRequest.getClassid(),"ID不存在");
		 }
		ClassSystem classSystem=optional.get();
		return new ClassResponse(classSystem.getClassid(), classSystem.getClassname(), classSystem.getCredit());
		
	}


	@Override
	public ClassResponse updatemember(ClassRequest classRequest) {
		if (classRequest.getClassid()==null|| !StringUtils.hasText(classRequest.getClassname())
				|| !StringUtils.hasText(classRequest.getDayOfWeek())||!StringUtils.hasText(classRequest.getStartTime())
				|| !StringUtils.hasText(classRequest.getEndTime()) || classRequest.getCredit()==null) {
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "失敗!!,格式錯誤");
		}

	    Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
	    if (!optional.isPresent()) {
	        return new ClassResponse(classRequest.getClassid(), "ID不存在");
	    }

	    ClassSystem classSystem = optional.get();
	    classSystem.setClassid(classRequest.getClassid());
	    classSystem.setClassname(classRequest.getClassname());
	    classSystem.setDayOfWeek(classRequest.getDayOfWeek());
	    classSystem.setStartTime(classRequest.getStartTime());
	    classSystem.setEndTime(classRequest.getEndTime());
	    classSystem.setCredit(classRequest.getCredit());
	    classDao.save(classSystem);

	    return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), classRequest.getDayOfWeek(),classRequest.getStartTime(),classRequest.getEndTime(),classRequest.getCredit(), "更新成功");
	}

	@Override
	public ClassResponse deleteMember(ClassRequest classRequest) {
		if (classRequest.getClassid()==null|| !StringUtils.hasText(classRequest.getClassname())
				|| !StringUtils.hasText(classRequest.getDayOfWeek())||!StringUtils.hasText(classRequest.getStartTime())
				|| !StringUtils.hasText(classRequest.getEndTime()) || classRequest.getCredit()==null) {
			return new ClassResponse(classRequest.getClassid(), classRequest.getClassname(), "失敗!!,格式錯誤");
		}

		    Optional<ClassSystem> optional = classDao.findById(classRequest.getClassid());
		    if (optional == null) {
		        return new ClassResponse("不能刪除");
		        }
		    
		    if (!optional.isPresent()) {
		        return new ClassResponse(classRequest.getClassid(), "ID不存在");
		    }		    		   
		   
		    
		    List<Selectcourse> selectcourses=selectcourseDao.findByClassid(classRequest.getClassid());
		    selectcourseDao.deleteAll(selectcourses);
		    
		    ClassSystem classSystem = optional.get();
		    classDao.delete(classSystem);

		    return new ClassResponse(classRequest.getClassid(),classRequest.getClassname(),"刪除成功");
	}

}
