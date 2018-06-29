package dao;

import java.util.List;

import entity.Teacher;

public interface TeacherDao {

	/**
	 * 根据教师工号查询教师信息
	 * @param id
	 * @return 返回教师信息
	 */
	Teacher queryById(String id);
	
	
	/**
	 * 添加教师记录
	 * @param id
	 * @param name
	 * @param phone
	 * @return  添加成功返回1，否则返回0
	 */
	int insertIntoTeacher(String id,String name , String phone);
	
	/**
	 * 根据教师工号删除教师记录
	 * @param id
	 * @return  成功删除返回1，否则返回0
	 */
	int deleteFromTeacher(String id);
	
	/**
	 * 查询所有教师
	 * @return 返回所有教师数组
	 */
	List<Teacher> queryAllTeacher();
	
}
