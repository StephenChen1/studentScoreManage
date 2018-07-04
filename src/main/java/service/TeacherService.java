package service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import entity.Teacher;

public interface TeacherService {

	/**
	 * 根据教师ID得到该教师的信息
	 * 
	 * @param teacherId
	 * @return
	 */
	Teacher getTeacherMessageById(String teacherId);

	/**
	 * 添加老师记录
	 * 
	 * @param id
	 * @param name
	 * @param phone
	 * @return
	 */
	boolean addTeacher(String id, String name, String phone);

	/**
	 * 返回所有的教师ID和教师名
	 * 
	 * @return
	 */
	List<Map<String, String>> getAllTeacherIdAndName();
}
