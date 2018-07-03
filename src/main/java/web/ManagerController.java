package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Teacher;
import service.TeachService;

@Controller
@RequestMapping("/managerTest")
public class ManagerController {

	@Autowired
	private TeachService teachService;

	/**
	 * 安排教学任务
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/arrange")
	public String arrange(Model model, HttpServletRequest request) {
		String course_id = request.getParameter("course_id");
		String teacher_id = request.getParameter("teacher_id");
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		boolean isOK = teachService.arrange(course_id, teacher_id,year,semester);
		model.addAttribute("isOK", isOK);
		return "ok";
	}

	/**
	 * 根据课程ID返回所有的任教老师
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getTeachers")
	public String getTeachers(Model model, HttpServletRequest request) {
		String course_id = request.getParameter("course_id");
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		List<Teacher> teachers = teachService.getTeachers(course_id,year,semester);
		model.addAttribute("teachers", teachers);
		return "manager/showTeachers";
		
	}
}
