package com.example.selectcourse.demo_course.service.impl;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.Selectcourse;
import com.example.selectcourse.demo_course.entity.StudentSystem;
import com.example.selectcourse.demo_course.repository.ClassDao;
import com.example.selectcourse.demo_course.repository.SelectcourseDao;
import com.example.selectcourse.demo_course.repository.StudentDao;
import com.example.selectcourse.demo_course.service.ifs.SelectcourseService;
import com.example.selectcourse.demo_course.vo.SelectRequest;
import com.example.selectcourse.demo_course.vo.SelectResponse;

@Service
public class SelectcourseServiceImpl implements SelectcourseService {
	
	@Autowired
	private SelectcourseDao selectcourseDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ClassDao classDao;

	@Override
	public SelectResponse selectclass(SelectRequest selectRequest) {
//		Integer studentId = selectRequest.getStudentid();
//	    Integer classId = selectRequest.getClassid();

	    // 檢查學生與課程是否存在
	    Optional<StudentSystem> optionalStudent = studentDao.findById(selectRequest.getStudentid());
	    Optional<ClassSystem> optionalClass = classDao.findById(selectRequest.getClassid());
	    
	    if (optionalStudent.isEmpty() || optionalClass.isEmpty()) {
	        return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "學生或課程不存在");
	    }
//	    StudentSystem student = optionalStudent.get();
//	    ClassSystem classSystem = optionalClass.get();

	    // 檢查是否選修過這門課程
	    Optional<Selectcourse> optionalSelectcourse = selectcourseDao.findByStudentidAndClassid(selectRequest.getStudentid(), selectRequest.getClassid());
	    if (optionalSelectcourse.isPresent()) {
	        return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "你已選過這門課程");
	    }
	    
	  //檢查學生修習上限是否超過10學分
	    List<Selectcourse> studentSelectcourses = selectcourseDao.findByStudentid(selectRequest.getStudentid());
	    int totalCredit = 0;
	    for (Selectcourse sc : studentSelectcourses) {
	        Optional<ClassSystem> optionalClassSystem = classDao.findById(sc.getClassid());
	        if (optionalClassSystem.isPresent()) {
	            totalCredit += optionalClassSystem.get().getCredit();
	        }
	    }
	    Optional<ClassSystem> optionalClassSystem = classDao.findById(selectRequest.getClassid());
	    if (optionalClassSystem.isPresent()) {
	        totalCredit += optionalClassSystem.get().getCredit();
	    }
	    if (totalCredit > 10) {
	        return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "你的學分已經超過10學分");
	    }

	    
	    

	    // 檢查學生是否選滿兩堂課
	    List<Selectcourse> selectcourses = selectcourseDao.findByStudentid(selectRequest.getStudentid());
	    if (selectcourses.size() >= 3) {
	        return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "你已選完三門課");
	    }
	    
	    
	    // 檢查課程是否已經選滿
//	    if (optionalClass.get().getId() >= 3) {
//	        return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "課程已經選滿");
//	    }
	    
	 // 檢查課程是否已經選滿
	    List<Selectcourse> seList=selectcourseDao.findByClassid(selectRequest.getClassid());
	    if(seList.size()>=3) {
	    	return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "課程已經選滿");
	    }
	    
	    //檢查選課時間是否重複
	    Optional<ClassSystem> sList2=classDao.findById(selectRequest.getClassid());
	    sList2.get().getDayOfWeek();
	    sList2.get().getStartTime();
	    for(Selectcourse selectcourse:selectcourses) {
	    	Integer isSelectid = selectcourse.getClassid();
	    	ClassSystem result = classDao.findById(isSelectid).get();
	    	result.getDayOfWeek();
	    	result.getStartTime();
	    	if(!result.getDayOfWeek().equals(sList2.get().getDayOfWeek())) {
	    		continue;
				}
	    	if (result.getStartTime().equals(sList2.get().getStartTime())) {
				return new SelectResponse(selectRequest.getClassname(),"課程衝堂");
		    }
	    	}
	    
	    //每位學生修習上限只能10學分，選課不能撞到一樣的時間
	    

	    

	    // 創建紀錄
//	    List<ClassSystem> classSystems=selectRequest.getClassSystems();
//	    List<StudentSystem> studentSystems=selectRequest.getStudentSystems();
//	    for(ClassSystem classList:classSystems) {
//	    	if (classList.getClassid()==null|| !StringUtils.hasText(classList.getClassname())
//					|| !StringUtils.hasText(classList.getDayOfWeek())||!StringUtils.hasText(classList.getStartTime())
//					|| !StringUtils.hasText(classList.getEndTime()) || classList.getCredit()==null) {				
//				return new SelectResponse(classList,selectRequest.getClassid(),"失敗!!,格式錯誤");
//			}
//	    }	    
	    Selectcourse selectcourse = new Selectcourse(selectRequest.getStudentid(), selectRequest.getClassid(), selectRequest.getClassname());
	    selectcourseDao.save(selectcourse);

	    return new SelectResponse(selectRequest.getStudentid(), selectRequest.getClassid(), "選課成功");
	}

	@Override
	public SelectResponse deleteselectclass(SelectRequest selectRequest) {
		Optional<Selectcourse> sOptional=selectcourseDao.findById(selectRequest.getClassname());
		selectcourseDao.delete(sOptional.get());
		return new SelectResponse("退選成功") ;
	}
}
