<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- csrf토큰 위한 taglib -->
<!-- 나중에 꾸미자... -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet" crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<form class="form-signin" method="post"
			action="/antmanager/user/signup">
			<sec:csrfInput />
			<!-- 이게 csrf토큰 Post에 꼭 넘겨주기-->
			<h2 class="form-signin-heading">회원가입</h2>
			<a>${existId}</a>
			<p>
				<label for="username">이름</label> <input type="text" id="username"
					name="username" class="form-control" value="${validId}" required
					autofocus>
			</p>
			<a>${passchck}</a>
			<p>
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password" class="form-control" required>
			</p>
			<p>
				<label for="password2">비밀번호확인</label> <input type="password"
					id="password2" name="password2" class="form-control" required>
			</p>
			<p>
				<label>비밀번호 힌트[선택사항]</label>
				<select name="userconfirmquestion" class="custom-select mb-3">
					<option value="비밀번호 확인 질문을 선택하지않았습니다" selected>비밀번호 확인 질문을 선택해주세요.</option>
					<option value="당신의 출신 초등학교는 어디인가요?">당신의 출신 초등학교는 어디인가요?</option>
					<option value="당신이 별명은 무엇인가요?">당신이 별명은 무엇인가요?</option>
					<option value="당신의 어머니 성함은 무엇인가요?">당신의 어머니 성함은 무엇인가요?</option>
					<option value="당신의 아버지 성함은 무엇인가요?">당신의 아버지 성함은 무엇인가요?</option>
				</select>
				<label>비밀번호 힌트 답[선택사항]</label>
				 <input type="text" id="userconfirmanswer" name="userconfirmanswer" class="form-control">
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>