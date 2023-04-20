package com.example.selectcourse.demo_course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.selectcourse.demo_course.entity.ClassSystem;

@Repository
public interface ClassDao extends JpaRepository<ClassSystem,Integer> {

//	List<ClassSystem> findByStudentsid(Integer id);

	List<ClassSystem> findByClassid(Integer id);

}
