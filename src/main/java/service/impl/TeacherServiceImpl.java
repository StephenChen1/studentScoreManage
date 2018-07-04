package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;
import dao.TeacherDao;
import entity.Course;
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
		return (teacherDao.addTeacher(id, name, phone) && loginDao.addLogin(id));
	}

	public List<Map<String, String>> getAllTeacherIdAndName() {
		List<Teacher> teacherList = teacherDao.queryAllTeacher();
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Teacher c : teacherList) {
			map = new HashMap<String, String>();
			map.clear();
			map.put("teacherId", c.getId());
			map.put("teacherName", c.getName());
			list.add(map);
		}
		return list;
	}
}
