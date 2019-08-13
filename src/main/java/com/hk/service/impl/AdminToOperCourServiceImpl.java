package com.hk.service.impl;

import com.hk.mapper.AdminToOperCourMapper;
import com.hk.pojo.Course;
import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyCourse;
import com.hk.service.AdminToOperCourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminToOperCourServiceImpl
 * @Description TODO
 * @Date 2019/7/10 9:23
 * @Created by HK
 */
@Service
public class AdminToOperCourServiceImpl implements AdminToOperCourService {
    @Resource
    private AdminToOperCourMapper adminToOperCourMapper;

    @Override
    public List<Teacher> getAllTeacher() {
        return adminToOperCourMapper.getAllTeacher();
    }

    @Override
    public int getTotalRows() {
        return adminToOperCourMapper.getTotalRows();
    }

    @Override
    public List<Course> getCourseByPage(PageBean pageBean) {
        return adminToOperCourMapper.getCourseByPage(pageBean);
    }

    @Override
    public int getCourseByNo(String no) {
        return adminToOperCourMapper.getCourseByNo(no);
    }

    @Override
    public void updateCourse(MyCourse course) {
        adminToOperCourMapper.updateCourse(course);
    }

    @Override
    public void addCourse(Course course) {
        adminToOperCourMapper.addCourse(course);
    }

    @Override
    public void deleteCourseById(int id) {
        adminToOperCourMapper.deleteCourseById(id);
    }

    @Override
    public void deleteCourseByIds(List<Integer> ids) {
        adminToOperCourMapper.deleteCourseByIds(ids);
    }

    @Override
    public void deleteCourseByTeacher(String teacherid) {
        adminToOperCourMapper.deleteCourseByTeacher(teacherid);
    }

    @Override
    public void deleteCourseByTeachers(List<String> teacherids) {
        adminToOperCourMapper.deleteCourseByTeachers(teacherids);
    }
}
