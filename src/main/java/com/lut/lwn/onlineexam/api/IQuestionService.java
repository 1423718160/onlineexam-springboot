package com.lut.lwn.onlineexam.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.bean.Questions;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public interface IQuestionService {
	@GetMapping("/findAllQuestion")
	public List<Questions> findAllQuestion();
	@GetMapping("/deleteQuestionById")
	public int deleteQuestionById(@Param("questionId") Long questionId);
	//随机出题
	@GetMapping("/randomQuestionById")
	public List<Questions> randomQuestionById();
	
	//新增
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody HashMap<String, String> question);
	
}
