package com.lut.lwn.onlineexam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.lut.lwn.onlineexam.bean.Questions;

@Component
public interface QuestionsRepository extends JpaRepository<Questions, Long>{
    //随机出单选题
	@Query(value  = "select id from Questions where type='单选'")
	List<Long> findRandomId();
	
	//按题目类型查询
	@Query(value  = "select q from Questions q where q.type=?1")
	public Questions findQuestionByType(String type);
	
}
