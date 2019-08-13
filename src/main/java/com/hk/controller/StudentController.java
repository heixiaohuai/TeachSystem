package com.hk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.pojo.SelectCourse;
import com.hk.pojo.StuScore;
import com.hk.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentController {
	@Autowired
	@Qualifier("studentService")
	private IStudentService stuService;
	
	@RequestMapping("/selectcourse")
	public void selectCourse(SelectCourse scourse, HttpServletResponse response) throws IOException {
		stuService.selectCourse(scourse);
		PrintWriter out = response.getWriter();
        out.print("The course selection is successful. This process is irreversible. If you have any questions, please contact the administrator.");
        out.flush();
	}
	
	@RequestMapping("/getStuScore")
	@ResponseBody
	public Object getStuScore(String no, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		List<StuScore> scoreList = stuService.getScore(no);
		return scoreList;
	}
}
