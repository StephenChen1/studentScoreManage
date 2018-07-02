package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.*;

public interface TeachDao {

	/**
	 * 安排某老师任教某学年的课程
	 * @param course_id
	 * @param teacher_id
	 * @param year
	 * @param semester
	 * @return
	 */
	public boolean add(@Param("course_id") String course_id, @Param("teacher_id") String teacher_id,
			@Param("year")String year,@Param("semester")int semester);

	/**
	 * 根据课程ID返回所有任教老师ID
	 * 
	 * @param course_id
	 * @return
	 */
	public List<String> getTeacherIDsByCID(@Param("course_id") String course_id);
}
