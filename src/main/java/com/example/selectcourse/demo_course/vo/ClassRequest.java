package com.example.selectcourse.demo_course.vo;

public class ClassRequest {
	private Integer classid;// �ҵ{�N�X

	private String classname;// �ҵ{�W��

	private String dayOfWeek;// �W�ҬP��

	private String startTime;// �W�Ҷ}�l�ɶ�

	private String endTime;// �W�ҵ����ɶ�

	private Integer credit;// �Ǥ�

	

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