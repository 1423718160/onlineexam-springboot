package com.lut.lwn.onlineexam.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lut.lwn.onlineexam.bean.StuResult;

public interface StuResultRepository extends JpaRepository<StuResult, Long>{

	/**
	 * @since 2019年6月5日
	 * void
	 * @param userId
	 * @param selectResult
	 */
	@Modifying
	@Transactional
	@javax.transaction.Transactional
	@Query(value = "update StuResult set resSingle=?2 where id=?1")
	void saveSelectResult(Long userId, int selectResult);

}
