package com.example.selectcourse.demo_course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassResponse {
	private Integer classid;// �ҵ{�N�X

	private String classname;// �ҵ{�W��

	private String dayOfWeek;// �W�ҬP��

	private String startTime;// �W�Ҷ}�l�ɶ�

	private String endTime;// �W�ҵ����ɶ�

	private Integer credit;// �Ǥ�
	
	private String message;

	public ClassResponse() {
		
	}


	public ClassResponse(Integer classid, String classname, String dayOfWeek, String startTime, String endTime, Integer credit,
			String message) {
		this.classid = classid;
		this.classname = classname;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
		this.message = message;
	}


	public ClassResponse(Integer classid, String classname,String message) {
		this.classid = classid;
		this.classname = classname;
		this.message=message;
	}
	
	

	public ClassResponse(Integer classid, String message) {
		this.classid = classid;
		this.message = message;
	}
	
	


	public ClassResponse(Integer classid, String classname, Integer credit) {
		this.classid = classid;
		this.classname = classname;
		this.credit = credit;
	}


	public ClassResponse(String message) {
		super();
		this.message = message;
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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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

