package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeachDao {

	/**
	 * 安排某老师任教某学年的课程
	 * 
	 * @param course_id
	 * @param teacher_id
	 * @param year
	 * @param semester
	 * @return
	 */
	public boolean add(@Param("course_id") String course_id, @Param("teacher_id") String teacher_id,
			@Param("year") String year, @Param("semester") int semester);

	/**
	 * 根据课程信息返回所有任教老师ID
	 * @param course_id
	 * @param year
	 * @param year
	 * @return
	 */

	

	public List<String> getYearsByTeacherId(@Param("teacherId")String teacherId);

	//获取学生年份
	public List<String> getYearsByStudentId(@Param("studentId")String studentId);

	public List<String> getTeacherIDs(@Param("course_id") String course_id, @Param("year") String year,
			@Param("semester") int semester);

	
	//把isEntered改为1或0
	boolean modifyIsEntered(@Param("teachId") String teachId,@Param("isEntered")int isEntered);

	//得到所有教学学年
	public List<String> getAllYears();


}
