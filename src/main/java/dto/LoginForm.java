package dto;

//登录时提交的信息
public class LoginForm {

	//身份
	private String position ;
	//id
	private String id ;
	//密码
	private String password ;
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
