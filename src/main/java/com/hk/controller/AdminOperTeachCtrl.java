package com.hk.controller;

import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.User;
import com.hk.pojo.mypojo.MyTeacher;
import com.hk.pojo.mypojo.MyUser;
import com.hk.service.AdminToOperCourService;
import com.hk.service.AdminToOperTeachService;
import com.hk.service.UserService;
import com.hk.utils.UploadImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Classname AdminOperTeachCtrl
 * @Description TODO
 * @Date 2019/7/9 20:17
 * @Created by HK
 */
@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class AdminOperTeachCtrl {
    @Resource
    private AdminToOperTeachService adminToOperTeachServiceImpl;
    @Resource
    private UserService userServiceImpl;
    @Resource
    private AdminToOperCourService adminToOperCourServiceImpl;

    @RequestMapping(value = "/addTeacher")
    public void addTeacher(Teacher teacher, MultipartFile timg, HttpServletRequest req,
                           HttpServletResponse resp, HttpSession session) throws IOException {
        String tno = teacher.getTno();
        if (adminToOperTeachServiceImpl.getTeacherByNo(tno) != 1 && userServiceImpl.getUserByAccount(tno) != 1){
            String imgpath = new UploadImgUtil().uploadImg(timg, req, resp, session);
            teacher.setUimg(imgpath);
            adminToOperTeachServiceImpl.addTeacher(teacher);
            User user = new User();
            user.setUserType(3);
            user.setUimg(imgpath);
            user.setUpwd(teacher.getTpwd());
            user.setUaccount(tno);
            userServiceImpl.addAdmin(user);
            PrintWriter out = resp.getWriter();
            out.print("<script>window.location.href ='/TeachSystem/admin/teacherman.html';</script>");
            out.flush();
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('Failed to add, username already used!');" +
                    "window.location.href ='/TeachSystem/admin/teacherman.html';</script>");
            out.flush();
        }
    }

    @RequestMapping(value = "/updateTeacher")
    public void updateTeacher(MyTeacher teacher, MultipartFile uimg, HttpServletRequest req,
                              HttpServletResponse resp, HttpSession session) throws IOException {
        System.out.println(teacher+"-----------");
        String imgpath = new UploadImgUtil().uploadImg(uimg, req, resp, session);
        teacher.setTimg(imgpath);
        adminToOperTeachServiceImpl.updateTeacher(teacher);
        MyUser user = new MyUser();
        user.setImg(imgpath);
        user.setPwd(teacher.getUpwd());
        user.setAccount(teacher.getUno());
        userServiceImpl.updateAdmin(user);
        PrintWriter out = resp.getWriter();
        out.print("<script>window.location.href ='/TeachSystem/admin/teacherman.html';</script>");
        out.flush();
    }

    @RequestMapping(value = "/getTeacherTotalRows")
    @ResponseBody
    public int getTotalRows(){
        return adminToOperTeachServiceImpl.getTotalRows();
    }

    @RequestMapping(value = "/getTeacherTotalPages")
    @ResponseBody
    public int getTotalPages(){
        return (adminToOperTeachServiceImpl.getTotalRows()/8)+1;
    }

    @RequestMapping(value = "/getTeacherByPage")
    @ResponseBody
    public Object getTeacherByPage(int currPage){
        return adminToOperTeachServiceImpl.getTeacherByPage(new PageBean(currPage, 8));
    }

    @RequestMapping(value = "/deleteTeacherById")
    public void deleteTeacherById(String did, HttpServletResponse resp) throws IOException {
        adminToOperCourServiceImpl.deleteCourseByTeacher(did);
        adminToOperTeachServiceImpl.deleteTeacherById(did);
        userServiceImpl.deleteAdmin(did);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }

    @RequestMapping(value = "/deleteTeacherByIds")
    public void deleteTeacherByIds(@RequestParam("myids[]") List<String> myids, HttpServletResponse resp) throws IOException {
        adminToOperCourServiceImpl.deleteCourseByTeachers(myids);
        adminToOperTeachServiceImpl.deleteTeachersByIds(myids);
        userServiceImpl.deleteAdminsByIds(myids);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }
}
