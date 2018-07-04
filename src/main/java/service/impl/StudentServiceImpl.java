package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;
import dao.StudentDao;
import entity.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private LoginDao loginDao;
	
	public List<Student> getStudentList() {

		return studentDao.queryAllStudent();
	}

	public boolean addStudent(String id, String name, String classes, String phone) {
		return(studentDao.addStudent(id, name, classes, phone) 
				&& loginDao.addLogin(id));
	}
}
