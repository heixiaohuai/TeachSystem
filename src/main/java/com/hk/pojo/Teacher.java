package com.hk.pojo;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int tid;
	private String tno;
	private String tname;
	private String tsex;
	private int tage;
	private String tdept;//部门
	private String ttitle;//职称
	private String tpwd;
	private String uimg;
	private String tremark;//备注
	private Set<Course> courses;

	public Teacher() {
		courses = new HashSet<Course>();
	}

	public Teacher(String tno, String tname, String tsex, int tage, String tdept, String ttitle, String tpwd, String uimg, String tremark, Set<Course> courses) {
		this.tno = tno;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tdept = tdept;
		this.ttitle = ttitle;
		this.tpwd = tpwd;
		this.uimg = uimg;
		this.tremark = tremark;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"tid=" + tid +
				", tno='" + tno + '\'' +
				", tname='" + tname + '\'' +
				", tsex='" + tsex + '\'' +
				", tage=" + tage +
				", tdept='" + tdept + '\'' +
				", ttitle='" + ttitle + '\'' +
				", tpwd='" + tpwd + '\'' +
				", uimg='" + uimg + '\'' +
				", tremark='" + tremark + '\'' +
				", courses=" + courses +
				'}';
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public int getTage() {
		return tage;
	}

	public void setTage(int tage) {
		this.tage = tage;
	}

	public String getTdept() {
		return tdept;
	}

	public void setTdept(String tdept) {
		this.tdept = tdept;
	}

	public String getTtitle() {
		return ttitle;
	}

	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getTremark() {
		return tremark;
	}

	public void setTremark(String tremark) {
		this.tremark = tremark;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
