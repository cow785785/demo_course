package com.example.selectcourse.demo_course.service.ifs;

import java.util.List;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.vo.ClassRequest;
import com.example.selectcourse.demo_course.vo.ClassResponse;



public interface ClassService {

	public ClassResponse addclass(ClassRequest classRequest);// 新增課程

	public List<ClassSystem> getAllClass();// 查詢所有課程

	public ClassResponse getClass(ClassRequest classRequest);// 用ID查詢單一課程

	public ClassResponse updatemember(ClassRequest classRequest);

	public ClassResponse deleteMember(ClassRequest classRequest);



}
