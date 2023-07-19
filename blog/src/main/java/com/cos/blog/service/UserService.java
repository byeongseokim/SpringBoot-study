package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.userRepository;
//스프링이 컴포넌트 스캔을 통해서Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private userRepository userRepository;

	@Transactional
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService:회원가입():" + e.getMessage());
		}
		return -1;
	}
}