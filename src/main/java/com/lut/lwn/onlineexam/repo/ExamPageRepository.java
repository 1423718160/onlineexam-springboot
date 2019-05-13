package com.lut.lwn.onlineexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.lut.lwn.onlineexam.bean.ExamPage;


@Component
public interface ExamPageRepository extends JpaRepository<ExamPage, Long>{

}
