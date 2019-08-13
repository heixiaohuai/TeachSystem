package com.hk.service;

import com.hk.pojo.Role;
import com.hk.pojo.mypojo.MyUser;
import com.hk.pojo.PageBean;
import com.hk.pojo.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/7/8 16:17
 * @Created by HK
 */
public interface UserService {
    User validateUser(User user);
    int getTotalRows();
    List<User> getUserByPage(PageBean page);
    void addAdmin(User user);
    void updateAdmin(MyUser user);
    void deleteAdmin(String id);
    void deleteAdminsByIds(List<String> ids);
    int getUserByAccount(String account);

    List<Role> getRole();
}
