package service;

import java.util.Map;

import entity.Manager;

public interface ManagerService {

	/**
	 * 根据ID获取教务员信息
	 * 
	 * @return
	 */
	public Manager queryById(String id);
}
