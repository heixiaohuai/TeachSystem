package com.hk.service.impl;

import com.hk.mapper.AdminToOperTeachMapper;
import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyTeacher;
import com.hk.service.AdminToOperTeachService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminToOperTeachServiceImpl
 * @Description TODO
 * @Date 2019/7/9 20:54
 * @Created by HK
 */
@Service
public class AdminToOperTeachServiceImpl implements AdminToOperTeachService {
    @Resource
    private AdminToOperTeachMapper adminToOperTeachMapper;

    @Override
    public int getTotalRows() {
        return adminToOperTeachMapper.getTotalRows();
    }

    @Override
    public List<Teacher> getTeacherByPage(PageBean pageBean) {
        return adminToOperTeachMapper.getTeacherByPage(pageBean);
    }

    @Override
    public void updateTeacher(MyTeacher teacher) {
        adminToOperTeachMapper.updateTeacher(teacher);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        adminToOperTeachMapper.addTeacher(teacher);
    }

    @Override
    public void deleteTeacherById(String id) {
        adminToOperTeachMapper.deleteTeacherById(id);
    }

    @Override
    public void deleteTeachersByIds(List<String> ids) {
        adminToOperTeachMapper.deleteTeachersByIds(ids);
    }

    @Override
    public int getTeacherByNo(String no) {
        return adminToOperTeachMapper.getTeacherByNo(no);
    }
}
