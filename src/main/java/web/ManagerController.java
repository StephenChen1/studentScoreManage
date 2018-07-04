package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Manager;
import entity.Teacher;
import service.LoginService;
import service.ManagerService;
import service.StudentService;
import service.TeachService;
import service.TeacherService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private TeachService teachService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ManagerService managerService;

	/**
	 * 安排教学任务
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/arrange")
	@ResponseBody
	public boolean arrange(Model model, HttpServletRequest request) {
		String course_id = request.getParameter("courseId");
		String teacher_id = request.getParameter("teacherId");
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		boolean isOK = teachService.arrange(course_id, teacher_id, year, semester);
		return isOK;
	}

	/**
	 * 根据课程ID返回所有的任教老师
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getTeachers")
	@ResponseBody
	public List<Teacher> getTeachers(HttpServletRequest request) {
		String course_id = request.getParameter("courseId");
		String year = request.getParameter("year");
		int semester = Integer.parseInt(request.getParameter("semester"));
		List<Teacher> teachers = teachService.getTeachers(course_id, year, semester);
		return teachers;
	}

	/**
	 * 判断输入的两次密码是否相同 不同的话blah blah blah待定 相同的话修改密码
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	@ResponseBody
	public boolean modifyPassword(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		boolean isOK = loginService.modifyPassword(id, password);
		return isOK;
	}

	/**
	 * 添加学生记录
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public boolean addStudent(HttpServletRequest request) {
		String id = request.getParameter("studentId");
		String name = request.getParameter("name");
		String classes = request.getParameter("class");
		String phone = request.getParameter("phone");
		boolean isOK = studentService.addStudent(id, name, classes, phone);
		return isOK;
	}

	/**
	 * 添加教师记录
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	@ResponseBody
	public boolean addTeacher(Model model, HttpServletRequest request) {
		String id = request.getParameter("teacherId");
		String name = request.getParameter("teacherName");
		String phone = request.getParameter("teacherPhone");
		boolean isOK = teacherService.addTeacher(id, name, phone);
		return isOK;
	}

	/**
	 * 获取当前登录教务员的信息
	 * 
	 * @param manager_id
	 * @return
	 */
	//TODO 测试
	@RequestMapping(value = "/getCurrentManager")
	@ResponseBody
	public Map<String, String> getCurrentManager(
			@CookieValue(value = "manager_id", required = false) String manager_id) {
		Manager currentM = managerService.queryById(manager_id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("managerName", currentM.getName());
		map.put("managerId", currentM.getId());
		return map;
	}
}
