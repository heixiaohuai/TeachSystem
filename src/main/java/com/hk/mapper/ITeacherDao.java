package com.hk.mapper;

import com.hk.pojo.*;

import java.util.List;

public interface ITeacherDao {
    List<MyCour> getMyCourse();
    List<MyCour> getMyCoursePage(PageBean page);
    int getMyCourseCount();

    List<MyScore> getMyScore();
    List<MyScore> getMyScorePage(PageBean page);
    int getMyScoreCount();

    List<InputScore> getInputScore(String grade, String cname);
    List<InputScore> getInputScorePage(PageBean page, String grade, String cname);
    int getInputScoreCount(String grade, String cname);
}
