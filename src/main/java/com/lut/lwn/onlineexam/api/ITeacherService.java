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

import com.lut.lwn.onlineexam.bean.Manager;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public interface ITeacherService {
	@GetMapping("/findAllTeacher")
	public List<Manager> findAllTeacher();
	@GetMapping("/deleteTeacherById")
	public int deleteTeacherById(@Param("teacherId") Long teacherId);
	@PostMapping("/addTeacher")
	public String addTeacher(@RequestBody HashMap<String, String> manager);
	@PostMapping("/updateTeacher")
	public String updateTeacher(@RequestBody HashMap<String, String> manager);
	
}
