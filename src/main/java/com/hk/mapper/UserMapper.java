package com.hk.mapper;

import com.hk.pojo.Role;
import com.hk.pojo.mypojo.MyUser;
import com.hk.pojo.PageBean;
import com.hk.pojo.User;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2019/7/8 15:53
 * @Created by HK
 */
public interface UserMapper {
    User validateUser(User user);
    int getTotalRows();
    List<User> getUserByPage(PageBean pageBean);
    void addAdmin(User user);
    void updateAdmin(MyUser user);
    void deleteAdmin(String id);
    void deleteAdminsByIds(List<String> ids);
    int getUserByAccount(String account);//检查账号是否重用
    List<Role> getRoles();
}
