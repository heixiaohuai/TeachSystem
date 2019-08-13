package com.hk.pojo;

public class PageBean {
	private int index;
	private int pageSize;

	public PageBean() {
		// TODO Auto-generated constructor stub
	}

	public PageBean(int curPage, int pageSize) {
		this.index = (curPage - 1) * pageSize;
		this.pageSize = pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
