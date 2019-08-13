package com.hk.service;

import java.util.List;


import com.hk.pojo.SelectCourse;
import com.hk.pojo.StuScore;

public interface IStudentService {
	void selectCourse(SelectCourse scourse);
	List<StuScore> getScore(String no);
}
