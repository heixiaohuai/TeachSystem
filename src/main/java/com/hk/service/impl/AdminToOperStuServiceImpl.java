package com.hk.service.impl;

import com.hk.mapper.AdminToOperStuMapper;
import com.hk.pojo.PageBean;
import com.hk.pojo.Student;
import com.hk.pojo.mypojo.MyStudent;
import com.hk.service.AdminToOperStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminToOperStuServiceImpl
 * @Description TODO
 * @Date 2019/7/9 12:06
 * @Created by HK
 */
@Service
public class AdminToOperStuServiceImpl implements AdminToOperStuService {
    @Resource
    private AdminToOperStuMapper adminToOperStuMapper;

    @Override
    public int getTotalRows() {
        return adminToOperStuMapper.getTotalRows();
    }

    @Override
    public List<Student> getStudentByPage(PageBean page) {
        return adminToOperStuMapper.getUserByPage(page);
    }

    @Override
    public void addStudent(Student student) {
        adminToOperStuMapper.addStudent(student);
    }

    @Override
    public void updateStudent(MyStudent student) {
        adminToOperStuMapper.updateStudent(student);
    }

    @Override
    public void deleteStudentById(String id) {
        adminToOperStuMapper.deleteStudentById(id);
    }

    @Override
    public void deleteStudentByIds(List<String> ids) {
        adminToOperStuMapper.deleteStudentsByIds(ids);
    }

    @Override
    public int getStudentByNo(String no) {
        return adminToOperStuMapper.getStuByNo(no);
    }
}
