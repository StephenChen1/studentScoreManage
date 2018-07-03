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
<<<<<<< HEAD
	public List<Teacher> getTeachersByCID(String course_id);
	
	
	public List<String> getYear(String teacherId);
	
=======
	public List<Teacher> getTeachers(String course_id,String year,int semester);
>>>>>>> c4e8409ca33a6ed292ee547b8f248c28e43e1909
}
