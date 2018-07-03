package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseMessageDao;
import entity.CourseSimpleMessage;
import entity.ScoreMessage;
import service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

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
}
