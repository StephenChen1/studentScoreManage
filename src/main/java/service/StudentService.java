package service;

import java.util.List;

import entity.Student;

public interface StudentService {

	/**
	 * 查询所有学生记录
	 * @return
	 */
	List<Student> getStudentList();
	
}

