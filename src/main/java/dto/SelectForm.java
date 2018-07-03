package dto;


//用来保存教师查询课程的条件
public class SelectForm {

	//年份
	private String year;
	//学期
	private String semester;
	//是否已经录入过
	private String isEntered;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getIsEntered() {
		return isEntered;
	}
	public void setIsEntered(String isEntered) {
		this.isEntered = isEntered;
	}
	
	
	
}
