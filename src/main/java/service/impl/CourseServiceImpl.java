package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseDao;
import dao.CourseMessageDao;
import entity.Course;
import entity.CourseSimpleMessage;
import entity.ScoreMessage;
import entity.StudentScoreMessage;
import service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	 @Autowired
	 private CourseMessageDao courseMessageDao ;
	
	 //实现根据教师Id，年份，学期,是否已经录入标识查找该教师的课程
     public List<CourseSimpleMessage> getCourseByIdYearSems(String teacherId,String year , int semester,String isEnteredFlag){
	
    	 int isEntered = 0 ;
    	 //为true表示查找已经录入成绩的课程
    	 if(isEnteredFlag.equals("true")){
    		 isEntered = 1 ;
    	 }else{
    		 isEntered = 0 ;
    	 }
    	 List<CourseSimpleMessage> courses = courseMessageDao.getCourseByIdYearSems(teacherId, year, semester, isEntered);
		 
    	 return courses ;
	 }
	
   //根据教学ID，查找该门课的学生成绩
 	public List<ScoreMessage> getScoreByTeachId(String teachId){
 		
 		//把参数传到dao层去查询
 		List<ScoreMessage> scores =  courseMessageDao.queryScoreByTeachId(teachId);
 		return scores ;
 	}
 	
 	//根据学生ID和学年、学期，查找该学生对应的成绩
 	 public List<StudentScoreMessage> getStudentScore(String studentId,String year,String semester){
 	 		
 	 	//把参数传到dao层去查询
 	 	List<StudentScoreMessage> scores =  courseMessageDao.queryStudentScore(studentId,year,semester);
 	 	return scores ;
 	 }
 	 	
	@Autowired
	private CourseDao courseDao;

	// 返回所有课程名与课程ID
	public List<Map<String, String>> getAllCourseIdAndName() {
		List<Course> courseList = courseDao.getAllCourses();
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Course c : courseList) {
			map = new HashMap<String, String>();
			map.clear();
			map.put("course_id", c.getCourseId());
			map.put("course_name", c.getName());
			list.add(map);
		}
		return list;
	}

}
