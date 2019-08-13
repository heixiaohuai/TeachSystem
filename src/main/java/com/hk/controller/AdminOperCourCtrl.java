package com.hk.controller;

import com.hk.pojo.Course;
import com.hk.pojo.PageBean;
import com.hk.pojo.Teacher;
import com.hk.pojo.mypojo.MyCourse;
import com.hk.service.AdminToOperCourService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Classname AdminOperCourCtrl
 * @Description TODO
 * @Date 2019/7/10 9:30
 * @Created by HK
 */
@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class AdminOperCourCtrl {
    @Resource
    private AdminToOperCourService adminToOperCourServiceImpl;

    @RequestMapping(value = "/getAllTeacher")
    @ResponseBody
    public Object getAllTeacher(){
        List<Teacher> allTeacher = adminToOperCourServiceImpl.getAllTeacher();
        return allTeacher;
    }

    @RequestMapping(value = "/addCourse")
    public void addCourse(Course course, HttpServletResponse resp) throws IOException {
        if (adminToOperCourServiceImpl.getCourseByNo(course.getCno()) != 1){
            adminToOperCourServiceImpl.addCourse(course);
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('"+ course.getCname() +"add success');" +
                    "window.location.href ='/TeachSystem/admin/courseman.html';</script>");
            out.flush();
        }else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('"+ course.getCname() +"add failed，this "+ course.getCno() +"already used');" +
                    "window.location.href ='/TeachSystem/admin/courseman.html';</script>");
            out.flush();
        }
    }

    @RequestMapping(value = "/updateCourse")
    public void updateCourse(MyCourse course, HttpServletResponse resp) throws IOException {
        adminToOperCourServiceImpl.updateCourse(course);
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('update class information success');" +
                "window.location.href ='/TeachSystem/admin/courseman.html';</script>");
        out.flush();
    }

    @RequestMapping(value = "/getCourTotalRows")
    @ResponseBody
    public int getTotalRows(){
        return adminToOperCourServiceImpl.getTotalRows();
    }

    @RequestMapping(value = "/getCourTotalPages")
    @ResponseBody
    public int getTotalPages(){
        return (adminToOperCourServiceImpl.getTotalRows()/8)+1;
    }

    @RequestMapping(value = "/getCourByPage")
    @ResponseBody
    public Object getCourByPage(int currPage){
        return adminToOperCourServiceImpl.getCourseByPage(new PageBean(currPage,8));
    }

    @RequestMapping(value = "/deleteCourById")
    public void deleteCourById(int did, HttpServletResponse resp) throws IOException {
        adminToOperCourServiceImpl.deleteCourseById(did);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }

    @RequestMapping(value = "/deleteCourByIds")
    public void deleteCourByIds(@RequestParam("myids[]") List<Integer> myids, HttpServletResponse resp) throws IOException {
        adminToOperCourServiceImpl.deleteCourseByIds(myids);
        PrintWriter out = resp.getWriter();
        out.print("delete success");
        out.flush();
    }
}
