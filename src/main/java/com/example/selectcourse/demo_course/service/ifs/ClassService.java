package com.example.selectcourse.demo_course.service.ifs;

import java.util.List;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.vo.ClassRequest;
import com.example.selectcourse.demo_course.vo.ClassResponse;



public interface ClassService {

	public ClassResponse addclass(ClassRequest classRequest);// �s�W�ҵ{

	public List<ClassSystem> getAllClass();// �d�ߩҦ��ҵ{

	public ClassResponse getClass(ClassRequest classRequest);// ��ID�d�߳�@�ҵ{

	public ClassResponse updatemember(ClassRequest classRequest);

	public ClassResponse deleteMember(ClassRequest classRequest);



}
