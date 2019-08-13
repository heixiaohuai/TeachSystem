package com.hk.service;


import com.hk.pojo.InputScore;
import com.hk.pojo.MyCour;
import com.hk.pojo.MyScore;
import com.hk.pojo.PageBean;

import java.util.List;

public interface ITeacherService {
    List<MyCour> getMyCourse();
    List<MyCour> getMyCoursePage(PageBean page);
    int getMyCourseCount();

    List<MyScore> getMyScore();
    List<MyScore> getMyScorePage(PageBean page);
    int getMyScoreCount();


    List<InputScore> getInputScore(String grade, String cname);
    List<InputScore> getInputScorePage(PageBean page, String grade, String cname);
    int getInputScoreCount(String grade, String cname);;
}
