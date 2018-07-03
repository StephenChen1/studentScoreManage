package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;
import dao.TeacherDao;
import entity.Teacher;
import service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private LoginDao loginDao;

	public Teacher getTeacherMessageById(String teacherId) {
		Teacher teacher = teacherDao.queryById(teacherId);
		return teacher;
	}

	/**
	 * 添加老师记录
	 * 
	 * @param id
	 * @param name
	 * @param phone
	 * @return
	 */
	public boolean addTeacher(String id, String name, String phone) {
		return ( teacherDao.addTeacher(id, name, phone)
				&& loginDao.addLogin(id)
		);
	}
}
