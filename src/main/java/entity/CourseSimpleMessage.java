package entity;


//简洁的课程信息，用来给教师查询他有哪些课程时，
//保存课程名和课程id,和该课程的教学id(以区别不同教学期间的同一个课程）
public class CourseSimpleMessage {

	//课程的教学id
	private String teachId ;
	//课程id
	private String courseId ;
	//课程名
	private String courseName;
	
	
	public String getTeachId() {
		return teachId;
	}
	public void setTeachId(String teachId) {
		this.teachId = teachId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
