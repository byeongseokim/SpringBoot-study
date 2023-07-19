package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 Bean 등록이 된다
//@Repository //생략가능하다.
public interface userRepository extends JpaRepository<User, Integer> {
	
	

}
