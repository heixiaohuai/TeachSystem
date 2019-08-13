package com.hk.pojo;

public class SelectCourse {
	private int id;
	private int student_id;
	private int course_id;
	private String flag;

	public SelectCourse() {
		// TODO Auto-generated constructor stub
	}

	public SelectCourse(int student_id, int course_id, String flag) {
		this.student_id = student_id;
		this.course_id = course_id;
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
