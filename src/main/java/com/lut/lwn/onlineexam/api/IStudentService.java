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

import com.lut.lwn.onlineexam.bean.Student;

@CrossOrigin
@RestController
@RequestMapping("/student")
public interface IStudentService {
    @GetMapping("/findAllStudent")
    public List<Student> findAllStudent();
    @GetMapping("/deleteStudentById")
	public int deleteStudentById(@Param("studentId") Long questionId);
    @PostMapping("/addStudent")
	public String addStudent(@RequestBody HashMap<String, String> student);
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestBody HashMap<String, String> student);
}
