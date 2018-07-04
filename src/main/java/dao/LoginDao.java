package dao;

import org.apache.ibatis.annotations.Param;

import entity.LoginMessage;

public interface LoginDao {

	/**
	 * 根据id查询登录表记录
	 * 
	 * @param id
	 * @return 返回一条记录或者没有
	 */
	LoginMessage queryById(@Param("id") String id);

	/**
	 * 修改（教师/学生）密码
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	boolean modifyPassword(@Param("id") String id, @Param("password") String password);
	
	/**
	 * 根据id插入用户记录，默认初始密码与id相同
	 * @param id
	 * @return
	 */
	boolean addLogin(@Param("id")String id);
}
