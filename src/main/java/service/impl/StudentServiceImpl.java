package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import entity.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao ;
	
	
	
	public List<Student> getStudentList() {
		
		return studentDao.queryAllStudent();
	}

	
}
