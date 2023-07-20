package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.userRepository;
//스프링이 컴포넌트 스캔을 통해서Bean에 등록을 해줌. IoC를 해준다.

@Service
public class UserService {

	@Autowired
	private userRepository userRepository;

	@Transactional
	public void 회원가입(User user) {
		/* try { */
		userRepository.save(user);
		/*
		 * return 1; } catch (Exception e) { e.printStackTrace();
		 * System.out.println("UserService:회원가입():" + e.getMessage()); } return -1;
		 */
	}

	// readOnly안될 경우 import에 전에 쓰던 Transactional 지우고 다시 저거로 잡아준다.
	// org.springframework.transaction.annotation.Transactional --> 옵션을
	// 허용(readonly=true? false) 가능
	@Transactional(readOnly = true) // Select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
	public User 로그인(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

}