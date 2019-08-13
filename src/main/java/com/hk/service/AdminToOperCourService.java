package com.hk.service;

import com.hk.pojo.Course;
import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyCourse;

import java.util.List;

/**
 * @Classname AdminToOperCourService
 * @Description TODO
 * @Date 2019/7/10 9:22
 * @Created by HK
 */
public interface AdminToOperCourService {
    List<Teacher> getAllTeacher();
    int getTotalRows();
    List<Course> getCourseByPage(PageBean pageBean);
    int getCourseByNo(String no);
    void updateCourse(MyCourse course);
    void addCourse(Course course);
    void deleteCourseById(int id);
    void deleteCourseByIds(List<Integer> ids);
    void deleteCourseByTeacher(String teacherid);
    void deleteCourseByTeachers(List<String> teacherids);
}
