package com.lut.lwn.onlineexam.impl;
/* 
 * 成绩信息，只可查询
 * 按准考证，姓名查询
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.api.IStuResultService;
import com.lut.lwn.onlineexam.bean.StuResult;
import com.lut.lwn.onlineexam.repo.StuResultRepository;
@CrossOrigin
@RestController
public class IStuResultServiceImpl implements IStuResultService{

	@Autowired
	private StuResultRepository stuResultRepository;
	@Override
	public List<StuResult> findAllResult(){
	List<StuResult> findAll = stuResultRepository.findAll();
	
	return findAll;
}
}
