package com.example.selectcourse.demo_course.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class ClassSystem {
	@Id
	@Column(name = "classid")
	private Integer classid;// �ҵ{�N�X

	@Column(name = "classname")
	private String classname;// �ҵ{�W��

	@Column(name = "classweek")
	private String dayOfWeek;// �W�ҬP��

	@Column(name = "starttime")
	private String startTime;// �W�Ҷ}�l�ɶ�

	@Column(name = "endtime")
	private String endTime;// �W�ҵ����ɶ�

	@Column(name = "credit")
	private Integer credit;// �Ǥ�

	public ClassSystem() {

	}

	public ClassSystem(Integer classid, String classname, String dayOfWeek, String startTime, String endTime, Integer credit) {
		this.classid = classid;
		this.classname = classname;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
	}


	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}


	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

}
