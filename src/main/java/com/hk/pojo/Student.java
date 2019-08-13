package com.hk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String no;
	private String name;
	private String sex;
	private int age;
	private String major;
	private String university;
	private String mobile;
	private String addr;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date start;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date end;
	private String pwd;
	private String grade;
	private String img;
	private Set<Course> courses;
	private Set<Score> scores;

	public Student() {
		courses = new HashSet<Course>();
		scores = new HashSet<Score>();
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", no='" + no + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", major='" + major + '\'' +
				", university='" + university + '\'' +
				", mobile='" + mobile + '\'' +
				", addr='" + addr + '\'' +
				", start=" + start +
				", end=" + end +
				", pwd='" + pwd + '\'' +
				", grade='" + grade + '\'' +
				", img='" + img + '\'' +
				", courses=" + courses +
				", scores=" + scores +
				'}';
	}

	public Student(String no, String name, String sex, int age, String major, String university, String mobile, String addr, Date start, Date end, String pwd, String grade, String img, Set<Course> courses, Set<Score> scores) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.major = major;
		this.university = university;
		this.mobile = mobile;
		this.addr = addr;
		this.start = start;
		this.end = end;
		this.pwd = pwd;
		this.grade = grade;
		this.img = img;
		this.courses = courses;
		this.scores = scores;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
}
