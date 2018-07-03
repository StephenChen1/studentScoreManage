package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Teacher;
import service.TeachService;
import service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService ;
	@Autowired
	private TeachService teachService ;
	
	@RequestMapping("/getTeacherMessage")
	@ResponseBody
	//通过@CookieValue("teacher_id") String teacherId获取教师id
	public Teacher getNowLoginTeacherMessage(@CookieValue(value = "teacher_id", required = false) String teacherId){
		
		if(teacherId != null){
			Teacher teacher = teacherService.getTeacherMessageById(teacherId);
			return teacher ;
		}
		
		return null ;		
	 }
	
	@RequestMapping("/getYear")
	@ResponseBody
	//通过@CookieValue("teacher_id") String teacherId获取教师id
	public List<String> getYear(@CookieValue(value = "teacher_id", required = false) String teacherId){
		
		if(teacherId != null){
			List<String> years = teachService.getYear(teacherId);
			return years ;
		}
		
		return null ;		
	 }
	
}
