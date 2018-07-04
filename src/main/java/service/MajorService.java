package service;

import dto.MajorScores;

public interface MajorService {

	
	//提交某课程的成绩
	boolean commitScores(MajorScores majorScores);
	
}
