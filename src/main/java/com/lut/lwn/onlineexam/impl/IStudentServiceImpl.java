package com.lut.lwn.onlineexam.impl;
import java.util.HashMap;
/*
 * 学生信息，增删改查
 * 按姓名和准考证号查询
 */
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.api.IStudentService;
import com.lut.lwn.onlineexam.bean.Student;
import com.lut.lwn.onlineexam.repo.StudentRepository;

@CrossOrigin
@RestController
public class IStudentServiceImpl implements IStudentService{
 @Autowired
 private StudentRepository studentRepository;
  @Override
  public List<Student> findAllStudent(){
	  List<Student> findAll = studentRepository.findAll();
	  return findAll;
  }
  @Override
	public int deleteStudentById(Long studentId) {
	  studentRepository.deleteById(studentId);
		return 0;
	}
@Override
public String addStudent(HashMap<String, String> student) {
    Student stu = new Student();
    stu.setName(student.get("name"));
    stu.setStuId(student.get("stuId"));
    stu.setStuCardNo(student.get("stuCardNo"));
     
    studentRepository.save(stu);
	return null;
}
@Override
public String updateStudent(HashMap<String, String> student) {
     String idStu = student.get("id");
     studentRepository.deleteById(Long.parseLong(idStu));
     
     Student stu = new Student();
     stu.setName(student.get("name"));
     stu.setStuId(student.get("stuId"));
     stu.setStuCardNo(student.get("stuCardNo"));
     studentRepository.save(stu);
	return null;
}
}
