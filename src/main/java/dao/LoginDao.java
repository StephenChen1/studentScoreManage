package dao;

import org.apache.ibatis.annotations.Param;

import entity.LoginMessage;

public interface LoginDao {

	/**
	 * 根据id查询登录表记录
	 * @param id
	 * @return 返回一条记录或者没有
	 */
	LoginMessage queryById(@Param("id")String id);
	
}
