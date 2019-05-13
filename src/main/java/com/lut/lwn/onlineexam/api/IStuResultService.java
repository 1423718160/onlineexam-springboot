package com.lut.lwn.onlineexam.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.bean.StuResult;


@CrossOrigin
@RestController
@RequestMapping("/result")
//学生成绩
public interface IStuResultService {
		@GetMapping("/findAllResult")
		public List<StuResult> findAllResult();
}
