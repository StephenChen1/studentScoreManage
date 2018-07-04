package dto;

//学生身份登录时，保存下拉框选中的年份和学期通过json数据传送到后台../course/getScores处理
public class YearAndSemesterRequest {
	private String year;
	private String semester;

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
}
