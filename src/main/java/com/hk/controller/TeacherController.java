package com.hk.controller;

import com.hk.pojo.InputScore;
import com.hk.pojo.MyCour;
import com.hk.pojo.MyScore;
import com.hk.pojo.PageBean;
import com.hk.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    @Qualifier("teacherService")
    private ITeacherService teacherService;


    @RequestMapping("/getmycoursecount")
    @ResponseBody
    public int getCoursesCount() {
        int count=teacherService.getMyCourseCount();
        return count;
    }

    @RequestMapping("/getmycoursepagestotal")
    @ResponseBody
    public int getCoursePagesTotal() {
        int count=teacherService.getMyCourseCount();
        int pages=(count+3-1)/3;
        return pages;
    }

    @RequestMapping("/getmycoursepages")
    @ResponseBody
    public Object getCoursePages(int curPage) {
        List<MyCour> mycourses=teacherService.getMyCoursePage(new PageBean(curPage, 3));
        for (MyCour m:mycourses){
            System.out.println(m);
        }
        return mycourses;
    }


    //学生成绩录入

    @RequestMapping("/getmyscorecount")
    @ResponseBody
    public int getScoreCount() {
        int count=teacherService.getMyScoreCount();
        return count;
    }

    @RequestMapping("/getmyscorepagestotal")
    @ResponseBody
    public int getScorePagesTotal() {
        int count=teacherService.getMyScoreCount();
        int pages=(count+3-1)/3;
        return pages;
    }

    @RequestMapping("/getmyscorepages")
    @ResponseBody
    public Object getScorePages(HttpServletRequest request, HttpSession session, int curPage) {

        List<MyScore> myscore=teacherService.getMyScorePage(new PageBean(curPage, 3));
        for (MyScore m:myscore){
            System.out.println(m.toString());
        }
        session.setAttribute("para",myscore);
        return myscore;
    }




    //    录入成绩
    @RequestMapping("/getinputscorecount")
    @ResponseBody
    public int getInputScoreCount(HttpServletRequest request, HttpSession session) {
        MyScore myScore =(MyScore) session.getAttribute("para");
        String grade = myScore.getGrade();
        String cname = myScore.getCname();
        int count=teacherService.getInputScoreCount(grade, cname);
        return count;
    }

    @RequestMapping("/getinputscorepagestotal")
    @ResponseBody
    public int getInputScorePagesTotal(HttpServletRequest request, HttpSession session) {
        MyScore myScore =(MyScore) session.getAttribute("para");
        String grade = myScore.getGrade();
        String cname = myScore.getCname();
        int count=teacherService.getInputScoreCount(grade, cname);
        int pages=(count+3-1)/3;
        return pages;
    }

    @RequestMapping("/getinputscorepages")
    @ResponseBody
    public Object getInputScorePages(HttpServletRequest request, HttpSession session, int curPage) {
        MyScore myScore =(MyScore) session.getAttribute("para");
        String grade = myScore.getGrade();
        String cname = myScore.getCname();
        System.out.println(grade+cname);
        List<InputScore> inputScorePage=teacherService.getInputScorePage(new PageBean(curPage, 3), grade, cname);
        for (InputScore m:inputScorePage){
            System.out.println(m.toString());
        }
        return inputScorePage;
    }

}
