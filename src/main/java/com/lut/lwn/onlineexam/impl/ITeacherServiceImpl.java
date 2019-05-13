package com.lut.lwn.onlineexam.impl;
import java.util.HashMap;
/*
 * 老师（管理员）信息，增删改查
 * 按姓名，账号查询
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.api.ITeacherService;
import com.lut.lwn.onlineexam.bean.Manager;
import com.lut.lwn.onlineexam.repo.ManagerRepository;
@CrossOrigin
@RestController
public class ITeacherServiceImpl implements  ITeacherService{
	@Autowired
	private ManagerRepository managerRepository;
	@Override
	public List<Manager> findAllTeacher() {
        List<Manager> findAll = managerRepository.findAll();
		return findAll;
	}
	@Override
	public int deleteTeacherById(Long teacherId) {
		managerRepository.deleteById(teacherId);
		return 0;		
	}
	@Override
	public String addTeacher(@RequestBody HashMap<String, String> manager) {
		Manager manager2 = new Manager();
		manager2.setName(manager.get("name"));
		manager2.setCardNo(manager.get("cardNo"));
		manager2.setPassword(manager.get("password"));
		
		managerRepository.save(manager2);
		return null;
	}
	@Override
	public String updateTeacher(@RequestBody HashMap<String, String> manager) {
		String idStr = manager.get("id");
		managerRepository.deleteById(Long.parseLong(idStr));
		
		Manager manager2 = new Manager();
		manager2.setName(manager.get("name"));
		manager2.setCardNo(manager.get("cardNo"));
		manager2.setPassword(manager.get("password"));
		
		managerRepository.save(manager2);
		
		
		return null;
	}

}
