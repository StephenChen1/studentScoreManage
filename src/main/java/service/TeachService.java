package service;

import java.util.List;

import entity.Teacher;

public interface TeachService {

	/**
	 * 安排某老师任教某课程
	 * 
	 * @param course_id
	 * @param teacher_id
	 * @return 成功返回true，失败返回false
	 */
	public boolean arrange(String course_id, String teacher_id,String year,int semester);

	/**
	 * 根据课程信息返回所有任教老师信息
	 * 
	 * @param course_id
	 * @return
	 */
	public List<Teacher> getTeachers(String course_id,String year,int semester);
}
