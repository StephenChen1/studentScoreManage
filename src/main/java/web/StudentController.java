package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.ModifyStudentPassword;
import entity.Student;
import service.LoginService;
import service.StudentService;
import service.TeachService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private TeachService teachService ;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		// 获取学生列表
		List<Student> list = studentService.getStudentList();
		for (Student student : list) {
			System.out.println(student);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getClasses());
			System.out.println(student.getPhone());
		}
		// 把数据添加到模型中,第二个参数对应上一句的list
		model.addAttribute("list", list);
		return "studentList";
	}

	@RequestMapping("/getStudentMessage")
	@ResponseBody
	// 通过@CookieValue("student_id") String studentId获取学生id
	public Student getNowLoginStudentMessage(
			@CookieValue(value = "student_id", required = false) String studentId) {

		if (studentId != null) {
			Student student = studentService.getStudentMessageById(studentId);
			return student;
		}

		return null;
	}

	@RequestMapping(value = "/modifyStudentPassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyStudentPassword(
			@CookieValue(value = "student_id", required = false) String studentId,
			@RequestBody ModifyStudentPassword modifyStudentPassword) {

		Map<String, Object> map = new HashMap<String, Object>();
		String rawPassword = modifyStudentPassword.getRawPassword();
		String newPassword = modifyStudentPassword.getNewPassword();
		String confirmPassword = modifyStudentPassword.getConfirmPassword();

		
		//首先判断输入是否为空
		if(rawPassword==""||newPassword==""||confirmPassword==""){
			map.put("modifyResult", "输入不能为空");
		}else{
			
			//获取数据库中的密码，再与输入rawPassword作比较
			String rawPasswordInDatabase = studentService.getStudentRawPassword(studentId);
			
			//首先判断输入原密码是否正确，在此前提下判断两次输入密码是否一致，若一致则修改密码
			if(rawPasswordInDatabase.equals(rawPassword)){
				if(newPassword.equals(confirmPassword)){
					boolean isOK = loginService.modifyPassword(studentId, newPassword);
					if(isOK){
						//前台通过modifyResult显示用户操作结果
						map.put("modifyResult", "修改密码成功");
					}
				}else{
					map.put("modifyResult", "两次输入密码不一致");
				}
			}else{
				map.put("modifyResult", "原密码输入错误");
			}
		}
		return map;
	}
	
	
	//根据ID获取该学生的年份列表
	@RequestMapping(value = "/getStudentYears", method = RequestMethod.POST)
	@ResponseBody
	public List<String> getStudentYears(@CookieValue(value = "student_id", required = false) String studentId){
		
		List<String> years = null ;
		
		if(studentId != null){
			 years = teachService.getStudentYear(studentId);
		}
		
		return years ;
		
	}

}
