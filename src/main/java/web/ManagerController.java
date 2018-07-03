package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Teacher;
import service.LoginService;
import service.TeachService;

@Controller
@RequestMapping("/managerTest")
public class ManagerController {

	@Autowired
	private TeachService teachService;
	@Autowired
	private LoginService loginService;

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
		boolean isOK = teachService.arrange(course_id, teacher_id, year, semester);
		model.addAttribute("isOK", isOK);
		return "manager/ok";
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
		List<Teacher> teachers = teachService.getTeachers(course_id, year, semester);
		model.addAttribute("teachers", teachers);
		return "manager/showTeachers";
	}

	/**
	 * 判断输入的两次密码是否相同
	 * 不同的话blah blah blah
	 * 相同的话修改密码
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	public String modifyPassword(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		if(!(password == confirm)) {
			return "notModified";
		}
		boolean isOK = loginService.modifyPassword(id, password);
		model.addAttribute("isOK", isOK);
		return "manager/modified";
	}
}
