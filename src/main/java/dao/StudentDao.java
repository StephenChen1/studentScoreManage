package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Student;

public interface StudentDao {

	/**
	 * 根据学号查询学生记录
	 * 
	 * @param id
	 * @return 返回学生记录
	 */
	Student queryById(@Param("id") String id);

	/**
	 * 查询所有学生
	 * 
	 * @return 返回学生数组
	 */
	List<Student> queryAllStudent();

	/**
	 * 添加学生记录
	 * 
	 * @param id
	 * @param name
	 * @param classes
	 * @param phone
	 * @return 添加成功返回1，否则返回0
	 */
	boolean addStudent(@Param("id") String id, @Param("name") String name, @Param("classes") String classes,
			@Param("phone") String phone);

	/**
	 * 根据id删除学生记录
	 * 
	 * @param id
	 * @return 删除成功返回1，否则返回0
	 */
	int deleteFromStudent(String id);

	/**
	 * test
	 * 
	 * @param id
	 * @return
	 */
	int test(String id);

	
	//获取学生数据库中的原密码
	String getStudentRawPassword(@Param("studentId")String studentId);

}
