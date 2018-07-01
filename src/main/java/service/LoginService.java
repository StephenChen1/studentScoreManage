package service;


public interface LoginService {

	//根据身份、id、密码  查询该用户是否能登录
	//position 身份信息，student teacher manager
	boolean judgeLogin(String position , String id , String password);
	
}
