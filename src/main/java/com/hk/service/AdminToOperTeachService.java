package com.hk.service;

import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyTeacher;

import java.util.List;

/**
 * @Classname AdminToOperTeachService
 * @Description TODO
 * @Date 2019/7/9 20:54
 * @Created by HK
 */
public interface AdminToOperTeachService {
    int getTotalRows();
    List<Teacher> getTeacherByPage(PageBean pageBean);
    void updateTeacher(MyTeacher teacher);
    void addTeacher(Teacher teacher);
    void deleteTeacherById(String id);
    void deleteTeachersByIds(List<String> ids);
    int getTeacherByNo(String no);
}
