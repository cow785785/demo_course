package com.example.selectcourse.demo_course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.selectcourse.demo_course.entity.Selectcourse;
@Repository
public interface SelectcourseDao extends JpaRepository<Selectcourse, String> {

	Optional<Selectcourse> findByStudentidAndClassid(Integer studentId, Integer classId);

//	List<Selectcourse> findByStudentid(Integer studentId);

	List<Selectcourse> findByClassid(Integer classId);

	List<Selectcourse> findByStudentid(Integer studentid);

}
