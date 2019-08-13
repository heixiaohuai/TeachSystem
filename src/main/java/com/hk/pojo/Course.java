package com.hk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Course {
	private int cid;
	private String cno;
	private String cname;
	private int ccredit;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date cstart;
	private String caddr;
	private String ckind;
	private Teacher teacher;
	private Set<Student> students;

	public Course() {
		students = new HashSet<Student>();
	}

	public Course(String cno, String cname, int ccredit, Date cstart, String caddr, String ckind, Teacher teacher, Set<Student> students) {
		this.cno = cno;
		this.cname = cname;
		this.ccredit = ccredit;
		this.cstart = cstart;
		this.caddr = caddr;
		this.ckind = ckind;
		this.teacher = teacher;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course{" +
				"cid=" + cid +
				", cno='" + cno + '\'' +
				", cname='" + cname + '\'' +
				", ccredit=" + ccredit +
				", cstart=" + cstart +
				", caddr='" + caddr + '\'' +
				", ckind='" + ckind + '\'' +
				", teacher=" + teacher +
				", students=" + students +
				'}';
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCcredit() {
		return ccredit;
	}

	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}

	public Date getCstart() {
		return cstart;
	}

	public void setCstart(Date cstart) {
		this.cstart = cstart;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public String getCkind() {
		return ckind;
	}

	public void setCkind(String ckind) {
		this.ckind = ckind;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
