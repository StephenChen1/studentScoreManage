package service;

import java.util.List;
import java.util.Map;

import entity.CourseSimpleMessage;
import entity.ScoreMessage;
import entity.StudentScoreMessage;
import entity.Course;

//课程接口
public interface CourseService {

	// 根据教师Id，年份，学期查找该教师的课程
	List<CourseSimpleMessage> getCourseByIdYearSems(String teacherId, String year, int semester, String isEnteredFlag);

	// 根据教学ID，查找该门课的学生成绩
	List<ScoreMessage> getScoreByTeachId(String teachId);
	
	//根据学生，查找该门课的学生成绩
	List<StudentScoreMessage> getStudentScore(String studentId,String year,String semester);
	

	// 返回所有课程名
	List<Map<String, String>> getAllCourseIdAndName();

}
