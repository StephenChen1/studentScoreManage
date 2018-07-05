package service;

import java.util.List;

import entity.Student;

public interface StudentService {

	/**
	 * 查询所有学生记录
	 * @return
	 */
	List<Student> getStudentList();
	
	/**
	 * 添加学生记录
	 * @param id
	 * @param name
	 * @param classes
	 * @param phone
	 * @return
	 */
	boolean addStudent(String id,String name,String classes,String phone);
	
	/**
	 * 根据学生ID得到该学生的信息
	 * @param teacherId
	 * @return
	 */
	Student getStudentMessageById(String studentId);
	
	//根据学生Id获取数据库中保存的密码
	String getStudentRawPassword(String studentId);
	
	
}

