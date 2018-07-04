package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MajorDao;
import dao.TeachDao;
import dto.MajorScores;
import dto.StudentIdAndScore;
import service.MajorService;

@Service
public class MajorServiceImpl implements MajorService{

	@Autowired
	private MajorDao majorDao ;
	
	@Autowired
	private TeachDao teachDao ;
	
	//提交某课程的所有学生的分数，循环调用dao方法修改分数,这个方法应该添加事务控制，要么都成功，要么都不成功
	//成功的话就把teach表中的isEntered值改为1，否则不变
	public boolean commitScores(MajorScores majorScores) {
		
		//int length = majorScores.getScoreList().length;
		String teachId = majorScores.getTeachId();
		//System.out.println("teachId:" + teachId);
		//System.out.println("length:" + length);
		/*for(StudentIdAndScore idAndScore : majorScores.getStudentIdAndScores()){
			System.out.println("studentId:" + idAndScore.getStudentId());
			System.out.println("studentScore:" + idAndScore.getStudentScore());
		}*/
		boolean modifySuccess = false ;
		for(StudentIdAndScore idAndScore : majorScores.getStudentIdAndScores()){
			
			modifySuccess = majorDao.modifyOneScore(teachId,idAndScore.getStudentId(), idAndScore.getStudentScore());
		    if(!modifySuccess){
		    	break;
		    }
		}
		//修改分数成功，则把teach表中的isEntered值改为1，否则不变
		if(modifySuccess){
			boolean isEnteredSuccess = teachDao.modifyIsEntered(teachId, 1);
		    if(!isEnteredSuccess){
		    	modifySuccess = false ;
		    }
		}
		
		return modifySuccess;
	}

}
