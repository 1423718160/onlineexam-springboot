package com.lut.lwn.onlineexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.lut.lwn.onlineexam.bean.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Long>{

}
