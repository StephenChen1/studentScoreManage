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
	public boolean arrange(String course_id, String teacher_id,String semester,int year);

	/**
	 * 根据课程ID返回所有任教老师
	 * 
	 * @param course_id
	 * @return
	 */
	public List<Teacher> getTeachersByCID(String course_id);
	
	
	public List<String> getYear(String teacherId);
	
}
