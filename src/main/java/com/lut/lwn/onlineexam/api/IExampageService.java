package com.lut.lwn.onlineexam.api;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.bean.ExamPage;


@CrossOrigin
@RestController
@RequestMapping("/page")
public interface IExampageService {
	@GetMapping("/findAllPage")
	public List<ExamPage> findAllPage();
/*	@GetMapping("/addAllPage")
	public int addAllPage();*/
}


