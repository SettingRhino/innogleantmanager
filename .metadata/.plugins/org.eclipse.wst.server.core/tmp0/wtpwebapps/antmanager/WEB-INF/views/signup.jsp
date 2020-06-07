<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<form method="post" action="/antmanager/user/signup">
	<sec:csrfInput /><!-- 이게 csrf토큰 Post에 꼭 넘겨주기-->
		<h2 class="form-signin-heading">Please sign up</h2>
		<a>${existId}</a>
		<p>
			<label for="username">Username</label> <input type="text"
				id="username" name="username" value="${validId}" required autofocus>
		</p>
		<a>${passchck}</a>
		<p>
			<label for="password">Password</label> <input type="password"
				id="password" name="password" required>
		</p>
		<p>
			<label for="password2">Password</label> <input type="password"
				id="password2" name="password2" required>
		</p>
		<button type="submit">Sign up</button>
	</form>
</body>
</html>