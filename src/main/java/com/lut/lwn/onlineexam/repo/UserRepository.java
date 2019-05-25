package com.lut.lwn.onlineexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lut.lwn.onlineexam.bean.User;

	public interface UserRepository extends JpaRepository<User, Long>{
}
