package dao;

import org.apache.ibatis.annotations.Param;

public interface MajorDao {

	//根据教学Id，学生Id，改学生分数
	boolean modifyOneScore(@Param("teachId")String teachId,@Param("studentId")String studentId,@Param("studentScore")double studentScore);
	
}
