package com.hk.service;

import com.hk.pojo.PageBean;
import com.hk.pojo.Student;
import com.hk.pojo.mypojo.MyStudent;

import java.util.List;

/**
 * @Classname AdminToOperStuService
 * @Description TODO
 * @Date 2019/7/9 12:06
 * @Created by HK
 */
public interface AdminToOperStuService {
    int getTotalRows();
    List<Student> getStudentByPage(PageBean page);
    void addStudent(Student Student);
    void updateStudent(MyStudent student);
    void deleteStudentById(String id);
    void deleteStudentByIds(List<String> ids);
    int getStudentByNo(String no);
}
