package com.hk.mapper;

import com.hk.pojo.Course;
import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyCourse;

import java.util.List;

/**
 * @Classname AdminToOperCourMapper
 * @Description TODO
 * @Date 2019/7/10 8:46
 * @Created by HK
 */
public interface AdminToOperCourMapper {
    List<Teacher> getAllTeacher();
    int getTotalRows();
    List<Course> getCourseByPage(PageBean pageBean);
    int getCourseByNo(String no);
    void updateCourse(MyCourse course);
    void addCourse(Course course);
    void deleteCourseById(int id);
    void deleteCourseByIds(List<Integer> ids);
    void deleteCourseByTeacher(String teacher);
    void deleteCourseByTeachers(List<String> ids);
}
