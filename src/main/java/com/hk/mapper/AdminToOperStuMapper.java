package com.hk.mapper;

import com.hk.pojo.PageBean;
import com.hk.pojo.Student;
import com.hk.pojo.mypojo.MyStudent;

import java.util.List;

/**
 * @Classname AdminToOperStuMapper
 * @Description TODO
 * @Date 2019/7/9 11:19
 * @Created by HK
 */
public interface AdminToOperStuMapper {
    int getTotalRows();
    List<Student> getUserByPage(PageBean pageBean);
    void updateStudent(MyStudent student);
    void addStudent(Student Student);
    void deleteStudentById(String id);
    void deleteStudentsByIds(List<String> ids);
    int getStuByNo(String no);
}
