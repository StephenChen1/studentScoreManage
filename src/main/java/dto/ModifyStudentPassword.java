package dto;

//用于修改学生密码时，通过json把表单数据提交到控制器中
public class ModifyStudentPassword {
	private String rawPassword;  //原密码
	private String newPassword;  //新密码
	private String confirmPassword;  //新密码确认

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
