package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
		System.out.println("UserApiController:save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 된다.
		user.setRole(RoleType.USER); // 이것만 강제로 입력 - User.java
		userService.회원가입(user);
		/* int result = userService.회원가입(user); */
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를JSON으로 변환해서 리턴(Jackson)
	} // result가 1이면 성공 -1이면 실패
	/*
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody User user) {
	 * System.out.println("UserApiController:login호출됨"); User principal =
	 * userService.로그인(user); // principal(접근주체)
	 * 
	 * if (principal != null) { session.setAttribute("principal", principal); }
	 * 
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */
	// 로그인은 이전 방법을 사용하지 않기 때문에
	// 상단에 있는 세션을 파라메트로 옮기고 주석처리함.
}
