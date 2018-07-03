package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;
import dao.ManagerDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.LoginMessage;
import service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private StudentDao studentDao ;
	@Autowired
	private TeacherDao teacherDao ;
	@Autowired
	private ManagerDao managerDao ;
	@Autowired
	private LoginDao loginDao ;
	//根据身份、id、密码  查询该用户是否能登录
	//1、根据身份，在指定表查询该用户是否存在，不存在返回false
	//2、根据id在登录表查询该用户是否存在且密码正确，否则返回false
	public boolean judgeLogin(String position,String id ,String password){
		//根据身份查询相应表
		Object result = null ;
		if(position.equals("student")){
			result = studentDao.queryById(id);
		}else if(position.equals("teacher")){
			result = teacherDao.queryById(id);
		}else if(position.equals("manager")){
			result = managerDao.queryById(id);
		}
		//如果结果不为空，说明已经找到该记录
		if(result != null){
			//接下来查找login表，看是否存在该账号和密码是否正确
			LoginMessage loginMessage = loginDao.queryById(id);
			if(loginMessage != null && loginMessage.getPassword().equals(password)){
				return true ;
			}
		}
		
		return false ;
	}
	
	//Controller确认两次输入密码相同后，调用该service修改密码
	//根据id确定修改谁的密码
	public boolean modifyPassword(String id,String password) {
		return loginDao.modifyPassword(id, password);
	}
}
