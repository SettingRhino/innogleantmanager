<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.0.1">
<title>Pricing example · Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/pricing/">

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- Favicons
<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon.ico">
 -->

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->

<link href="<c:url value="/resources/css/pricing.css"/>"
	rel="stylesheet">
</head>
<body>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<p align="center">
				<a href="<c:url value="/"/>" class="btn btn-primary" role="button">처음으로</a>
			</p>
		</h5>
		<nav class="my-2 my-md-0 mr-md-3"></nav>
		<a class="btn btn-outline-primary"
			href="<c:url value="/user/signup"/>">회원가입</a> <a
			class="btn btn-outline-primary" href="<c:url value="/login"/>">로그인</a>
		<form id="logout" action="<c:url value="/logout" />" method="post">
			<sec:csrfInput />
		</form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a class="btn btn-outline-primary"
				href="javascript:document.getElementById('logout').submit()">로그아웃</a>
		</c:if>
	</div>

	<div class="container-wrapper">
		<div class="container">
			<h1 style="color: gray;">단골 손님 상세보기</h1>


			<div
				class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
				<hr>
				<p>
				<h2>${customer.customer_name}</h2>
				</p>
				<hr>
				<h4 style="color: gray;">특징</h4>
				<br />
				<p style="font-size: 18pt">${customer.customer_character}</p>
				<hr>
				<h4 style="color: gray;">기타사항</h4>
				<br />
				<p style="font-size: 18pt">${customer.customer_etc}</p>
				<hr>
				<p>
					<a
						href="<c:url value="/customers/deleteCustomer?id=${customer.id}"/>"
						class="btn btn-danger">삭제</a> <a
						href="<c:url value="/customers/updateCustomer?user=${customer.user}&id=${customer.id}"/>"
						class="btn btn-warning btn-large">수정</a>
				</p>
				<hr>
			</div>

			<div class="container" align="right">
				<a href="<c:url value="/customers" />" class="btn btn-dark">목록으로</a>
			</div>
		</div>
	</div>


	<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>
	</div>
</body>
</html>





