package com.hk.pojo;

public class Role {
	private int rid;
	private String rname;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String rname) {
		this.rname = rname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

}
