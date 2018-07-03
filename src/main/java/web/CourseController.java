package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.SelectForm;
import dto.TeachId;
import entity.CourseSimpleMessage;
import entity.ScoreMessage;
import service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService ;
	
	
	@RequestMapping("/serchOneTeacherCourses")
	@ResponseBody
	//通过@CookieValue("teacher_id") String teacherId获取教师id
	public List<CourseSimpleMessage> getCourseByIdYearSeme(@RequestBody SelectForm selectForm,@CookieValue(value = "teacher_id", required = false) String teacherId){
		System.out.println("year："+selectForm.getYear());
		System.out.println("semester："+selectForm.getSemester());
		System.out.println("isEnteredFlag："+selectForm.getIsEntered());
		//教师id从cookie中找到,判断是否有该cookie，没有则返回空值
		if(teacherId == null){
			//TODO
			return null ;
		}else{
		    String year = selectForm.getYear() ;
		    int semester = Integer.parseInt(selectForm.getSemester());
		    //是否已经录入过成绩
		    String isEnteredFlag = selectForm.getIsEntered();
		    //传参查询
		    List<CourseSimpleMessage> courses = courseService.getCourseByIdYearSems(teacherId, year, semester, isEnteredFlag);
		    if(courses != null){
		    	for(CourseSimpleMessage c : courses){
		    		System.out.println("teachId:"+c.getTeachId());
		    		System.out.println("courseId:"+c.getCourseId());
		    		System.out.println("courseName:"+c.getCourseName());
		    	}
		    }
		    return courses ;
		 }		
	 }
	
	//serchOneCourseScores
	//查找某一门课程的成绩,即通过教学id查找到的就是选修该门课的学生的成绩
	@RequestMapping("/serchOneCourseScores")
	@ResponseBody
	public List<ScoreMessage> getScoreByTeachId(@RequestBody TeachId teachId){
		String myTeachId = teachId.getTeachId();
		//传值查找
		List<ScoreMessage> scores = courseService.getScoreByTeachId(myTeachId);
		return scores ;
		
	}
	
}
