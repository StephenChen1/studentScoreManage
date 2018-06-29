package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Student;
import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService ;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(Model model){
		//获取学生列表
		List<Student> list = studentService.getStudentList();
		for(Student student: list){
			System.out.println(student);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getClasses());
			System.out.println(student.getPhone());
		}
		//把数据添加到模型中,第二个参数对应上一句的list
		model.addAttribute("list", list);
		return "studentList" ;
	}
}
