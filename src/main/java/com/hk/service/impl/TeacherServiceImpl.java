package com.hk.service.impl;

import com.hk.mapper.ITeacherDao;
import com.hk.pojo.InputScore;
import com.hk.pojo.MyCour;
import com.hk.pojo.MyScore;
import com.hk.pojo.PageBean;
import com.hk.service.ITeacherService;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao;

    public ITeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<MyCour> getMyCourse() {
        return teacherDao.getMyCourse();
    }

    @Override
    public List<MyCour> getMyCoursePage(PageBean page) {
        return teacherDao.getMyCoursePage(page);
    }

    @Override
    public int getMyCourseCount() {
        return teacherDao.getMyCourseCount();
    }


    @Override
    public List<MyScore> getMyScore() {
        return teacherDao.getMyScore();
    }

    @Override
    public List<MyScore> getMyScorePage(PageBean page) {
        return teacherDao.getMyScorePage(page);
    }

    @Override
    public int getMyScoreCount() {
        return teacherDao.getMyScoreCount();
    }


    @Override
    public List<InputScore> getInputScore(String grade, String cname) {
        return teacherDao.getInputScore(grade,cname);
    }

    @Override
    public List<InputScore> getInputScorePage(PageBean page, String grade, String cname) {
        return teacherDao.getInputScorePage(page,grade,cname);
    }

    @Override
    public int getInputScoreCount(String grade, String cname) {
        return teacherDao.getInputScoreCount(grade,cname);
    }
}
