package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest:";

	@GetMapping("/http/lombok")
	public String lombokTest() {
	  Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
	  System.out.println(TAG+"getter:"+m.getId());
	  m.setId(5000);
	  System.out.println(TAG+"setter:"+m.getId());
	  return "lombok test 완료";
	}

	// get 방식으로 데이터를 전달하는 방법은 쿼리스트링 방식 밖에는 없음
	@GetMapping("http/get")
	/*
	 * public String getTest(@RequestParam int id, @RequestParam String username) {
	 * return "get 요청" + id + "," + username;
	 */
	public String getTest(Member m) {
		return "get 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}

	@PostMapping("http/post")
//	public String postTest(Member m) {
//		return "post 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	/*
	 * public String postTest(@RequestBody String text) { return "post 요청:" + text;
	 */
	// text/plain, application/ json
	public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트)
		return "post 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();

	}

	@PutMapping("http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();

	}

	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
