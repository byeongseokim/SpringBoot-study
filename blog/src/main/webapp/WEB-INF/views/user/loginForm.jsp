<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<!-- 로그인창 -->
<div class="container">
	<form action="/blog/api/user/login">
		<div class="form-group">
			<label for="email">이메일 주소:</label> <input type="email"
				class="form-control" placeholder="이메일 주소를 입력해주세요!" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호:</label> <input type="password"
				class="form-control" placeholder="비밀번호를 입력해주세요!" id="pwd">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox">로그인 기억하기
			</label>
		</div>
	</form>
	<button id="btn-login" class="btn btn-primary">로그인</button>
</div>
<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>