package service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ManagerDao;
import entity.Manager;
import service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	public Manager queryById(String id){
		Manager m = managerDao.queryById(id);
		return m;
	}
}
