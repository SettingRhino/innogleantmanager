<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

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
		<h5 class="my-0 mr-md-auto font-weight-normal"><p align="center"><a href="<c:url value="/"/>" class="btn btn-primary" role="button">처음으로</a></p></h5>
		<nav class="my-2 my-md-0 mr-md-3">
		</nav>
		<a class="btn btn-outline-primary"
			href="<c:url value="/user/signup"/>">회원가입</a> <a
			class="btn btn-outline-primary" href="<c:url value="/login"/>">로그인</a>
		<a class="btn btn-outline-primary" href="<c:url value="/logout"/>">로그아웃</a>
	</div>
		<div class="row"> 
		<div class="col-lg-4"></div>
		<div class="col-lg-4"></div>
		<div class="col-lg-4" align="right">
		<a href="<c:url value="/diary/edit?user=${diary.user}&id=${diary.id}"/>" class="btn btn-info" role="button">수 정 하 기</a>
		<a href="<c:url value="/diary/view"/>" class="btn btn-info" role="button">목 록 보 기</a>
		</div>
		</div>
	<div class="container-fluid">
		<div class="table table-bordered">
			<h1 class="bg-light text-dark" align="center">${diary.title}</h1>
			<div class="bg-light text-dark">
				<p class="lead">${diary.contents}</p>
			</div>
			<div class="bg-light text-dark">
			<div class="row">
				<div class="col-lg-4">
					<h4>
						비고
						</h4>
				</div>
				<div class="col-lg-8" align="right">
					<h5>${diary.date}</h5>
				</div>
			</div>
			</div>
			<div><br></div>
			<div class="bg-light text-dark">
			<!-- 비고 내용 -->${diary.description}
			</div>
			
		</div>
	</div>
	<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>

</body>
</html>