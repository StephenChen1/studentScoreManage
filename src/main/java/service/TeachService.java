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
	public boolean arrange(String course_id, String teacher_id, String year, int semester);

	public List<String> getYear(String teacherId);
	
	//获取学生的年份
	public List<String> getStudentYear(String studentId);

	public List<Teacher> getTeachers(String course_id, String year, int semester);

}
