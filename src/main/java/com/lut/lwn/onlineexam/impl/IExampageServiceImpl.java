package com.lut.lwn.onlineexam.impl;
/*
 * 考卷信息，只可查
 * 按准考证，姓名查询
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.api.IExampageService;
import com.lut.lwn.onlineexam.bean.ExamPage;
import com.lut.lwn.onlineexam.repo.ExamPageRepository;

@CrossOrigin
@RestController
public class IExampageServiceImpl implements IExampageService{
	@Autowired
	private ExamPageRepository examPageRepository;
	@Override
	public List<ExamPage> findAllPage() {
		List<ExamPage> findAll = examPageRepository.findAll();
		return findAll;
	}
}
