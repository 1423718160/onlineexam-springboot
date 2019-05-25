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

import com.lut.lwn.onlineexam.bean.User;


@CrossOrigin
@RestController
@RequestMapping("/user")
public interface UserService {
	@GetMapping("/findAllUser")
	public List<User> findAllTeacher();
	@GetMapping("/deleteUserById")
	public int deleteUserById(@Param("UserId") Long userId);
	@PostMapping("/addUser")
	public String addUser(@RequestBody HashMap<String, String> user);
	@PostMapping("/updateUser")
	public String updateUser(@RequestBody HashMap<String, String> user);
	
}
