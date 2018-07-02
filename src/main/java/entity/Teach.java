package entity;

/**
 * 联系集Teach
 * @author banana
 *
 */
public class Teach {

	private int teach_id;
	
	private String teacher_id;

	private String course_id;

	private String year;
	
	private int semester;
	
	private boolean is_entered;
	
	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getTeach_id() {
		return teach_id;
	}

	public void setTeach_id(int teach_id) {
		this.teach_id = teach_id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isIs_entered() {
		return is_entered;
	}

	public void setIs_entered(boolean is_entered) {
		this.is_entered = is_entered;
	}

}
