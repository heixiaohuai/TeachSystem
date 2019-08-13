package com.hk.controller;

import com.hk.pojo.PageBean;
import com.hk.pojo.Student;
import com.hk.pojo.User;
import com.hk.pojo.mypojo.MyStudent;
import com.hk.pojo.mypojo.MyUser;
import com.hk.service.AdminToOperStuService;
import com.hk.service.UserService;
import com.hk.utils.UploadImgUtil;
import com.hk.utils.UploadImgUtil;
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
import java.util.List;

/**
 * @Classname AdminToOperStuController
 * @Description 该控制器的内容为管理员对学生信息的操作
 * @Date 2019/7/9 11:17
 * @Created by HK
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminOperStuCtrl {
    @Resource
    private AdminToOperStuService adminToOperStuServiceImpl;
    @Resource
    private UserService userServiceImpl;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public void addStudent(Student stu, MultipartFile simg, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String sno = stu.getNo();
        if (adminToOperStuServiceImpl.getStudentByNo(sno) != 1 && userServiceImpl.getUserByAccount(sno) != 1){
            String imgpath = new UploadImgUtil().uploadImg(simg, req, resp, session);
            stu.setImg(imgpath);
            adminToOperStuServiceImpl.addStudent(stu);
            User user = new User();
            user.setUaccount(sno);
            user.setUpwd(stu.getPwd());
            user.setUimg(imgpath);
            user.setUserType(2);
            userServiceImpl.addAdmin(user);
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/admin/stuman.html';</script>");
            out.flush();
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('Failed to add, StudentNo already used!');" +
                    "window.location.href ='/TeachSystem/admin/stuman.html';</script>");
            out.flush();
        }

    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public void updateStudent(MyStudent mystu, MultipartFile uimg, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String imgpath = new UploadImgUtil().uploadImg(uimg, req, resp, session);
        mystu.setSimg(imgpath);
        adminToOperStuServiceImpl.updateStudent(mystu);
        MyUser myUser = new MyUser();
        myUser.setPwd(mystu.getUpwd());
        myUser.setImg(imgpath);
        myUser.setAccount(mystu.getUno());
        userServiceImpl.updateAdmin(myUser);
        PrintWriter out = resp.getWriter();
        out.print("<script>window.location.href ='/TeachSystem/admin/stuman.html';</script>");
        out.flush();
    }

    @RequestMapping(value = "/getStuTotalRows", method = RequestMethod.POST)
    @ResponseBody
    public int getTotalRows(){
        int totalRows = adminToOperStuServiceImpl.getTotalRows();
        return totalRows;
    }

    @RequestMapping(value = "/getStuTotalPages", method = RequestMethod.POST)
    @ResponseBody
    public int getTotalPages(){
        int totalRows = adminToOperStuServiceImpl.getTotalRows();
        int totalPages = (totalRows/3)+1;
        return totalPages;
    }

    @RequestMapping(value = "/getStuByPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getStuByPage(int currPage){
        List<Student> studentByPage = adminToOperStuServiceImpl.getStudentByPage(new PageBean(currPage, 3));
        for (Student s:studentByPage){
            System.out.println(s);
        }
        return studentByPage;
    }

    @RequestMapping(value = "/deleteStuById", method = RequestMethod.POST)
    public void deleteStuById(String did,HttpServletResponse resp) throws IOException {
        adminToOperStuServiceImpl.deleteStudentById(did);
        userServiceImpl.deleteAdmin(did);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }

    @RequestMapping(value = "/deleteStuByIds", method = RequestMethod.POST)
    public void deleteStuByIds(@RequestParam("myids[]") List<String> myids, HttpServletResponse resp) throws IOException {
        adminToOperStuServiceImpl.deleteStudentByIds(myids);
        userServiceImpl.deleteAdminsByIds(myids);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }
}
