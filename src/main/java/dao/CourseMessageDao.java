package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.CourseSimpleMessage;
import entity.ScoreMessage;

public interface CourseMessageDao {

	//根据教师Id，年份，学期查找该教师的课程
	List<CourseSimpleMessage> getCourseByIdYearSems(@Param("teacherId")String teacherId,@Param("year")String year , @Param("semester")int semester,@Param("isEnteredFlag")int isEnteredFlag);


	//根据教学ID去查询该门课的成绩
	List<ScoreMessage> queryScoreByTeachId(@Param("teachId")String teachId);
}
