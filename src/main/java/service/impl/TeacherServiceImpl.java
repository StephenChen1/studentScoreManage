package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TeacherDao;
import entity.Teacher;
import service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherDao ;
	
	public Teacher getTeacherMessageById(String teacherId) {
		Teacher teacher = teacherDao.queryById(teacherId);
		return teacher;
	}

}
