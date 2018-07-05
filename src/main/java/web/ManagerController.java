package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.IdAndPassword;
import dto.SelectTeacherForm;
import dto.TeachMessageForm;
import entity.Manager;
import entity.Student;
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
	public boolean arrange(@RequestBody TeachMessageForm teachMessageForm) {
		String course_id = teachMessageForm.getCourseId();
		String teacher_id = teachMessageForm.getTeacherId();
		String year = teachMessageForm.getYear();
		System.out.println("year:"+year);
		System.out.println("semester:"+teachMessageForm.getSemester());
		int semester = Integer.parseInt(teachMessageForm.getSemester());
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
	public List<Teacher> getTeachers(@RequestBody SelectTeacherForm selectTeacherForm) {
		String courseId = selectTeacherForm.getCourseId();
		String year = selectTeacherForm.getYear();
		int semester = Integer.parseInt(selectTeacherForm.getSemester());
		List<Teacher> teachers = teachService.getTeachers(courseId, year, semester);
		for(Teacher teacher : teachers){
			System.out.println("teacher:" +teacher.getId());
			System.out.println("teacher:" +teacher.getName());
		}
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
	public boolean modifyPassword(@RequestBody IdAndPassword  idAndPassword) {
		String id = idAndPassword.getId();
		String password = idAndPassword.getPassword();
		boolean isOK = loginService.modifyPassword(id, password);
		System.out.println("ISOK：" + isOK);
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
	public boolean addStudent(@RequestBody Student student) {
		String id = student.getId();
		String name = student.getName();
		String classes = student.getClasses();
		String phone = student.getPhone();
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
	public boolean addTeacher(@RequestBody Teacher teacher) {
		String id = teacher.getId();
		System.out.println("addTeacherID:" + id);
		String name = teacher.getName();
		String phone = teacher.getPhone();
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
	
	
	
	//无参数得到所有学年
	@RequestMapping(value="/getAllYears")
	@ResponseBody
	public List<String> getAllYears(){
		List<String> years = teachService.getAllYears();
		return years ;
	}
	
	
	
}
