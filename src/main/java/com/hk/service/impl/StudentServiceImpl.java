package com.hk.service.impl;

import java.util.List;


import com.hk.mapper.IStudentDao;
import com.hk.pojo.SelectCourse;
import com.hk.pojo.StuScore;
import com.hk.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao stuDao;

	public IStudentDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(IStudentDao stuDao) {
		this.stuDao = stuDao;
	}

	@Override
	public void selectCourse(SelectCourse scourse) {
		// TODO Auto-generated method stub
		stuDao.selectCourse(scourse);
	}

	@Override
	public List<StuScore> getScore(String no) {
		return stuDao.getScore(no);
	}
	
	

}
