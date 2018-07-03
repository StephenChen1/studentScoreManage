package service;


public interface LoginService {

	//根据身份、id、密码  查询该用户是否能登录
	//position 身份信息，student teacher manager
	boolean judgeLogin(String position , String id , String password);
	
	//Controller确认两次输入密码相同后，调用该service修改密码
	//根据id确定修改谁的密码
	boolean modifyPassword(String id,String password);
}
