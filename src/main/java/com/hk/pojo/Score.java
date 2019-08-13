package com.hk.pojo;

public class Score {
	private int id;
	private String year;
	private String term;
	private double score;
	private String flag;
	private Student student;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(String year, String term, double score, String flag, Student student) {
		this.year = year;
		this.term = term;
		this.score = score;
		this.flag = flag;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", year=" + year + ", term=" + term + ", score=" + score + ", flag=" + flag
				+ ", student=" + student + "]";
	}

}
