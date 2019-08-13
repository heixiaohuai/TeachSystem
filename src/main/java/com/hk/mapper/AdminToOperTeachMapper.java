package com.hk.mapper;

import com.hk.pojo.PageBean;
import com.hk.pojo.Student;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyStudent;
import com.hk.pojo.mypojo.MyTeacher;

import java.util.List;

/**
 * @Classname AdminToOperTeachMapper
 * @Description TODO
 * @Date 2019/7/9 20:18
 * @Created by HK
 */
public interface AdminToOperTeachMapper {
    int getTotalRows();
    List<Teacher> getTeacherByPage(PageBean pageBean);
    void updateTeacher(MyTeacher teacher);
    void addTeacher(Teacher teacher);
    void deleteTeacherById(String id);
    void deleteTeachersByIds(List<String> ids);
    int getTeacherByNo(String no);
}
