<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<p align="center"><a href="<c:url value="/"/>" class="btn btn-primary" role="button">처음으로</a></p>
	<c:if test="${not empty start}"><!-- 처음이면 get-->
		<form class="form-signin" method="get" action="<c:url value="/user/forgetpassword"/>">
		
			<a>${notExistId}</a>
			<p>
				<label for="username">이름</label> <input type="text" id="username"
					name="username" class="form-control" required autofocus>
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">아이디확인</button>
			</form>
	</c:if>
	<c:if test="${empty start}">
	<c:if test="${not empty notconfirmchk}"><!-- 아이디 확인 됬지만, 찾기 진행 못해. -->
	<form class="form-signin">
				<h4><label for="username">해당 ${username}은<br>${notconfirmchk}</label></h4>
				<a href="<c:url value="/user/forgetpassword"/>" class="btn btn-lg btn-primary btn-block" role="button">확인</a>
			</form>
	</c:if>
	<c:if test="${empty notconfirmchk}"><!-- 질문 답이 된다. -->
		<form class="form-signin" method="post" action="<c:url value="/user/forgetpassword"/>"><!-- 여긴 아이디 확인이 끝난곳. -->
			<sec:csrfInput />
			<!-- 이게 csrf토큰 Post에 꼭 넘겨주기-->
			<h2 class="form-signin-heading">비밀번호 찾기</h2>
			<a class="text-danger">${passchck}${answerchck}</a>
			<p>
				<input type="text" class="form-control" value="${username}" disabled>
				<input type="hidden" id="username" name="username" value="${username}">
			</p>
			<p>
				<label>비밀번호</label> <input type="password" id="password" name="password" class="form-control" required>
			</p>
			<p>
				<label>비밀번호확인</label> <input type="password" id="password2" name="password2" class="form-control" required>
			</p>
			<p>
				<label>${userconfirmquestion}</label>
				
				<input type="hidden" id="userconfirmquestion" name="userconfirmquestion" value="${userconfirmquestion}">
				 <input type="text" id="userconfirmanswer" name="userconfirmanswer" class="form-control">
			</p>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">변경</button>
			</form>
			</c:if>
	</c:if>
	</div>
</body>
</html>