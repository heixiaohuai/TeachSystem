package com.hk.pojo;

public class User {
	private int uid;
	private String uaccount;
	private String upwd;
	private String uimg;
	private int userType;
	private Role role;
	private Student student;
	private Teacher teacher;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUaccount() {
		return uaccount;
	}

	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", uaccount='" + uaccount + '\'' +
				", upwd='" + upwd + '\'' +
				", uimg='" + uimg + '\'' +
				", userType=" + userType +
				", role=" + role +
				", student=" + student +
				", teacher=" + teacher +
				'}';
	}

	public User(String uaccount, String upwd, String uimg, int userType, Role role, Student student, Teacher teacher) {
		this.uaccount = uaccount;
		this.upwd = upwd;
		this.uimg = uimg;
		this.userType = userType;
		this.role = role;
		this.student = student;
		this.teacher = teacher;
	}

	public User() {

	}
}
