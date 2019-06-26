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
	//随机出题(单选)
	@PostMapping("/randomQuestionById")
	public List<Questions> randomQuestionById();
	//随机出题(编程)
	@PostMapping("/randomQuestionProgram")
	public List<Questions> randomQuestionProg();
		
	//选择题成绩入库
	@PostMapping("/saveSelectResult")
	public void saveSelectResult(@Param("userId") Long userId , @Param("selectResult") int selectResult);
	
	//以学号建立文件夹，将前端填写的代码写为文件，得到运行后结果，对比答案
	@PostMapping("executeProgramFile")
	public String excuteProgram(@Param("content") String content);
	
	
	//新增
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody HashMap<String, String> question);
	
}
