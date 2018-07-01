package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Manager;
import entity.Teacher;

public interface ManagerDao {

	/**
	 * 根据教务员工号查询教务员信息
	 * @param id
	 * @return 返回教务员信息
	 */
	Manager queryById(@Param("id")String id);
	
	
	/**
	 * 添加教务员记录
	 * @param id
	 * @param name
	 * @param phone
	 * @return  添加成功返回1，否则返回0
	 */
	int insertIntoManager(String id,String name , String phone);
	
	/**
	 * 根据教务员工号删除教师记录
	 * @param id
	 * @return  成功删除返回1，否则返回0
	 */
	int deleteFromManager(String id);
	
	/**
	 * 查询所有教务员
	 * @return 返回所有教务员数组
	 */
	List<Manager> queryAllManager();
	
}
