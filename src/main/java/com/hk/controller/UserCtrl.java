package com.hk.controller;

import com.hk.pojo.*;
import com.hk.pojo.mypojo.MyStudent;
import com.hk.pojo.mypojo.MyTeacher;
import com.hk.pojo.mypojo.MyUser;
import com.hk.service.*;
import com.hk.utils.UploadImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2019/7/8 16:31
 * @Created by HK
 */
@Controller
public class UserCtrl {
    @Resource
    private UserService userServiceImpl;
    @Resource
    private AdminToOperStuService adminToOperStuServiceImpl;
    @Resource
    private AdminToOperTeachService adminToOperTeachServiceImpl;

    private Map<String, User> userMap=new HashMap<String, User>();
    /**
     * @Description 产生一个独一无二的id，用于区分用户
     * @param
     * @return java.lang.String
     * @date 2019/7/8 19:07
     * @author HK
     */
    private String generateId(){
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        sb.append(System.currentTimeMillis());
        for (int i=0; i<10; i++){
            sb.append(r.nextInt(10));
        }
        return sb.toString();
    }


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String validateUser(User user, HttpSession session){
        User loginUser = userServiceImpl.validateUser(user);
        if (loginUser == null){
            session.setAttribute("error","Wrong username and password, please log in again");
            return "redirect:login";
        }
        String result="/login.html";
        String id;
//        Map<String, User> userMap = new HashMap<>();
        switch (loginUser.getRole().getRid()){
            case 1://管理员
                {
                    id = generateId();
                    userMap.put(id, loginUser);
                    session.setAttribute("userMap", userMap);
                    session.setAttribute("username","username");
                    result = "/admin/admin.html?id="+id;
                }
                break;
            case 2://学生
                {
                    id = generateId();
                    userMap.put(id, loginUser);
                    session.setAttribute("userMap", userMap);
                    session.setAttribute("username","username");
                    result = "/student/student.html?id="+id;
                }
                break;
            case 3://老师
                {
                    id = generateId();
                    userMap.put(id, loginUser);
                    session.setAttribute("userMap", userMap);
                    session.setAttribute("username","username");
                    result = "/teacher/teacher.html?id="+id;
                }
                break;
            default:
                break;
        }
        return "redirect:"+result;
    }

    @RequestMapping(value = "/getrole")
    @ResponseBody
    public Object getRole(){
        List<Role> roles = userServiceImpl.getRole();
        return roles;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public User getUserInfo(String id, HttpSession session){
        Map<String, User> userMap = (Map<String, User>) session.getAttribute("userMap");
        User user = userMap.get(id);
        return user;
    }

    @RequestMapping(value = "/getUserTotalRows", method = RequestMethod.POST)
    @ResponseBody
    public int getUserCount(){
        int count = userServiceImpl.getTotalRows();
        return count;
    }

    @RequestMapping(value = "/getUserTotalPages", method = RequestMethod.POST)
    @ResponseBody
    public int getTotalUserPages(){
        int count = userServiceImpl.getTotalRows();
        int pages = (count/8)+1;
        return pages;
    }

    @RequestMapping(value = "/getUserByPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getUserByPage(int currPage){
        List<User> userList = userServiceImpl.getUserByPage(new PageBean(currPage, 8));
        return userList;
    }

    @RequestMapping("/addAdmin")
    public void addUser(User user,@RequestParam("role_id") int role_id,MultipartFile simg,HttpServletRequest request,
                        HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException {
        String account = user.getUaccount();
        String imgpath = "";
        if (role_id == 1){
            if (userServiceImpl.getUserByAccount(account)!=1){
                imgpath = new UploadImgUtil().uploadImg(simg, request, response, session);
                user.setUimg(imgpath);
                user.setUserType(role_id);
                userServiceImpl.addAdmin(user);
                PrintWriter out = response.getWriter();
                out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }else {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('Failed to add, username already used!');" +
                        "window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }
        }else if(role_id == 2){
            if (userServiceImpl.getUserByAccount(account)!=1 && adminToOperStuServiceImpl.getStudentByNo(account) != 1){
                imgpath = new UploadImgUtil().uploadImg(simg, request, response, session);
                user.setUimg(imgpath);
                user.setUserType(role_id);
                userServiceImpl.addAdmin(user);
                Student student = new Student();
                student.setNo(account);
                student.setPwd(user.getUpwd());
                student.setImg(imgpath);
                adminToOperStuServiceImpl.addStudent(student);
                PrintWriter out = response.getWriter();
                out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }else {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('Failed to add, username already used!');" +
                        "window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }
        }else {
            if (userServiceImpl.getUserByAccount(account)!=1 && adminToOperTeachServiceImpl.getTeacherByNo(account) != 1){
                imgpath = new UploadImgUtil().uploadImg(simg,request,response,session);
                user.setUimg(imgpath);
                user.setUserType(role_id);
                userServiceImpl.addAdmin(user);
                Teacher teacher = new Teacher();
                teacher.setTno(account);
                teacher.setTpwd(user.getUpwd());
                teacher.setUimg(imgpath);
                adminToOperTeachServiceImpl.addTeacher(teacher);
                PrintWriter out = response.getWriter();
                out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }else {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('Failed to add, username already used!');" +
                        "window.location.href ='/TeachSystem/admin/adminman.html';</script>");
                out.flush();
            }
        }

    }

    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public void updateUser(MyUser myuser,@RequestParam("role_id") int role_id, MultipartFile uimg, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        if (role_id == 1){
            String imgPath = new UploadImgUtil().uploadImg(uimg, req, resp, session);
            myuser.setImg(imgPath);
            myuser.setUserType(role_id);
            userServiceImpl.updateAdmin(myuser);
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
            out.flush();
        }else if (role_id == 2){
            String imgPath = new UploadImgUtil().uploadImg(uimg, req, resp, session);
            myuser.setImg(imgPath);
            myuser.setUserType(role_id);
            userServiceImpl.updateAdmin(myuser);
            MyStudent student = new MyStudent();
            student.setUpwd(myuser.getPwd());
            student.setSimg(imgPath);
            adminToOperStuServiceImpl.updateStudent(student);
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
            out.flush();
        }else {
            String imgPath = new UploadImgUtil().uploadImg(uimg, req, resp, session);
            myuser.setImg(imgPath);
            myuser.setUserType(role_id);
            userServiceImpl.updateAdmin(myuser);
            MyTeacher myTeacher = new MyTeacher();
            myTeacher.setUpwd(myuser.getPwd());
            myTeacher.setTimg(imgPath);
            adminToOperTeachServiceImpl.updateTeacher(myTeacher);
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/admin/adminman.html';</script>");
            out.flush();
        }
    }

    @RequestMapping(value = "deleteAdminById", method = RequestMethod.POST)
    public void deleteAdminById(String did, HttpServletResponse resp) throws IOException {
        userServiceImpl.deleteAdmin(did);
        adminToOperTeachServiceImpl.deleteTeacherById(did);
        adminToOperStuServiceImpl.deleteStudentById(did);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }

    @RequestMapping(value = "deleteAdminsByIds", method = RequestMethod.POST)
    public void deleteAdminsByIds(@RequestParam("myids[]") List<String> myids, HttpServletResponse resp) throws IOException {
        userServiceImpl.deleteAdminsByIds(myids);
        adminToOperTeachServiceImpl.deleteTeachersByIds(myids);
        adminToOperStuServiceImpl.deleteStudentByIds(myids);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }
}
