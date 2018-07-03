package entity;

//用来保存某个学生在某节课的成绩，主要用于教师界面的成绩展示
public class ScoreMessage {

	//学生id
     private String studentId ;
     //学生姓名
     private String studentName;
     //学生所在班级
     private String classes ;
     //该节课的得分
     private double score ;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
     
     
	
}
