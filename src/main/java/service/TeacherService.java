package service;

import org.springframework.stereotype.Service;

import entity.Teacher;


public interface TeacherService {

	/**
	 * 根据教师ID得到该教师的信息
	 * @param teacherId
	 * @return
	 */
	Teacher getTeacherMessageById(String teacherId);
	
}
