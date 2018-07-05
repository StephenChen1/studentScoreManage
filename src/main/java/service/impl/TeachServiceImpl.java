package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TeachDao;
import dao.TeacherDao;
import entity.Teacher;
import service.TeachService;

@Service
public class TeachServiceImpl implements TeachService {

	@Autowired
	private TeachDao teachDao;
	@Autowired
	private TeacherDao teacherDao;

	/**
	 * 调用teachDao.add方法，完成教学任务的安排
	 */
	public boolean arrange(String course_id, String teacher_id, String year, int semester) {
		return teachDao.add(course_id, teacher_id, year, semester);
	}

	/**
	 * 调用teachDao.getTeacherIDs方法，获取所有的教师ID 根据教师ID，调用teacherDao中的方法获取所有教师信息
	 */
	public List<Teacher> getTeachers(String course_id, String year, int semester) {
		List<String> teacherIDs = teachDao.getTeacherIDs(course_id, year, semester);
		List<Teacher> teacherList = new ArrayList<Teacher>();
		for (String teacher_id : teacherIDs) {
			teacherList.add(teacherDao.queryById(teacher_id));
		}
		return teacherList;
	}

	public List<String> getYear(String teacherId) {
		List<String> years = teachDao.getYearsByTeacherId(teacherId);
		return years;
	}
	
	public List<String> getStudentYear(String studentId) {
		List<String> years = teachDao.getYearsByStudentId(studentId);
		return years;
	}

	public List<String> getAllYears() {
		List<String> years = teachDao.getAllYears();
		return years;
	}

}
