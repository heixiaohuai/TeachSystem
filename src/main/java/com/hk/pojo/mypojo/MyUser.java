package com.hk.pojo.mypojo;

public class MyUser {
	private int myno;
	private String account;
	private String pwd;
	private String img;
	private int userType;

	public MyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyUser(int myno, String account, String pwd, String img, int userType) {
		this.myno = myno;
		this.account = account;
		this.pwd = pwd;
		this.img = img;
		this.userType = userType;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "MyUser{" +
				"myno=" + myno +
				", account='" + account + '\'' +
				", pwd='" + pwd + '\'' +
				", img='" + img + '\'' +
				", userType=" + userType +
				'}';
	}
}
