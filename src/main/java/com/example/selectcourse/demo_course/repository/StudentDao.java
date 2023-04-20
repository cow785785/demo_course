package com.example.selectcourse.demo_course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.selectcourse.demo_course.entity.ClassSystem;
import com.example.selectcourse.demo_course.entity.StudentSystem;
@Repository
public interface StudentDao extends JpaRepository<StudentSystem, Integer> {

//	boolean existsById(String studentname);

//	List<ClassSystem> findSelectedCoursesByStudentId();

}
