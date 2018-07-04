package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.ModifyStudentPassword;
import dto.YearAndSemesterRequest;
import entity.StudentScoreMessage;
import entity.Teacher;
import service.LoginService;
import service.StudentService;
import service.TeachService;
import service.TeacherService;

@Controller
@RequestMapping("/managerTest")
public class ManagerController {

	@Autowired
	private TeachService teachService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
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
	 * 判断输入的两次密码是否相同 不同的话blah blah blah待定 相同的话修改密码
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	public String modifyPassword(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		if (!(password.equals(confirm))) {
			return "manager/notModified";
		}
		boolean isOK = loginService.modifyPassword(id, password);
		model.addAttribute("isOK", isOK);
		return "manager/modified";
	}
	

	/**
	 * 添加学生记录
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String classes = request.getParameter("class");
		String phone = request.getParameter("phone");
		boolean isOK = studentService.addStudent(id, name, classes, phone);
		model.addAttribute("isOK", isOK);
		return "manager/addStudent";
	}

	/**
	 * 添加教师记录
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addTeacher(Model model, HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println("name = " + name);

		boolean isOK = teacherService.addTeacher(id, name, phone);
		model.addAttribute("isOK", isOK);

		return "manager/addTeacher";
	}

}
