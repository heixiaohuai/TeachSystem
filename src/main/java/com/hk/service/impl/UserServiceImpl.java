package com.hk.service.impl;

import com.hk.mapper.UserMapper;
import com.hk.pojo.Role;
import com.hk.pojo.mypojo.MyUser;
import com.hk.pojo.PageBean;
import com.hk.pojo.User;
import com.hk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/7/8 16:18
 * @Created by HK
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<Role> getRole() {
        return userMapper.getRoles();
    }

    @Override
    public User validateUser(User user) {
        return userMapper.validateUser(user);
    }

    @Override
    public int getTotalRows() {
        return userMapper.getTotalRows();
    }

    @Override
    public List<User> getUserByPage(PageBean page) {
        return userMapper.getUserByPage(page);
    }

    @Override
    public void addAdmin(User user) {
        userMapper.addAdmin(user);
    }

    @Override
    public void updateAdmin(MyUser user) {
        userMapper.updateAdmin(user);
    }

    @Override
    public void deleteAdmin(String id) {
        userMapper.deleteAdmin(id);
    }

    @Override
    public void deleteAdminsByIds(List<String> ids) {
        userMapper.deleteAdminsByIds(ids);
    }

    @Override
    public int getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
