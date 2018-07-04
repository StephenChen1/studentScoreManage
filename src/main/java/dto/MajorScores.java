package dto;

import java.util.List;

public class MajorScores {

	//教学id
	private String teachId ;
	//学生id和分数数组
	private StudentIdAndScore[] studentIdAndScores ;
	
	
	public String getTeachId() {
		return teachId;
	}
	public void setTeachId(String teachId) {
		this.teachId = teachId;
	}
	public StudentIdAndScore[] getStudentIdAndScores() {
		return studentIdAndScores;
	}
	public void setStudentIdAndScores(StudentIdAndScore[] studentIdAndScores) {
		this.studentIdAndScores = studentIdAndScores;
	}
	
	
	
	
	
}
