package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 Bean 등록이 된다
//@Repository //생략가능하다.
public interface userRepository extends JpaRepository<User, Integer> {
	
	// JAP Naming 쿼리
	// SELECT * FROM user WHERE username=?1 AND password=?2;
	User findByUsernameAndPassword(String username, String password);
	//@Qudery(value="SELECT * FROM user WHERE username=?1 AND password=?2, nativeQuery = true)
	//User login(String username, String password);


}
