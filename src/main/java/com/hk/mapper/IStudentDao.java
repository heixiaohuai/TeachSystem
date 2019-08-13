package com.hk.mapper;

import java.util.List;


import com.hk.pojo.PageBean;
import com.hk.pojo.SelectCourse;
import com.hk.pojo.StuScore;

public interface IStudentDao {
	void selectCourse(SelectCourse scourse);
	List<StuScore> getScore(String no);
	int getScoreTotalRows(String no);
	List<StuScore> getScoreByPage(PageBean page, String no);
}
