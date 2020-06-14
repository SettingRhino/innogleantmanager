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
		<form id="logout" action="<c:url value="/logout" />" method="post">
			<sec:csrfInput />
		</form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a class="btn btn-outline-primary"
				href="javascript:document.getElementById('logout').submit()">로그아웃</a>
		</c:if>
	</div>
	
		
		<sf:form action="${pageContext.request.contextPath}/diary/edit" method="post" modelAttribute="diary">
	<div class="container-fluid">
		<div class="table table-bordered"><div align="right"><button type="submit" class="btn btn-primary">글 등 록 하 기</button></div>
			<h2 class="bg-light text-dark" align="center"><label for="usr">제목</label>
      <input type="text" class="form-control" id="title" name="title" value="${diary.title}"></h2>
			<sf:errors path="title" cssStyle="color:#ff0000;"/>
			<div class="bg-light text-dark">
				<div align="center"><p class="lead"><label for="comment">일지</label></div>
      <textarea class="form-control" rows="10" id="contents" name="contents" >${diary.contents}</textarea>
    </div>
			</div>
			<div class="bg-light text-dark"align="center">
			<h3>비고</h3>
			</div>
			<div><br></div>
			<div class="bg-light text-dark">
			 <textarea class="form-control" rows="5" id="description" name="description">${diary.description}</textarea>
			</div>
			<input type="hidden" id="date" name="date" value="${diary.date}">
			<c:if test="${not empty diary.id}">
			<input type="hidden" id="id" name="id" value="${diary.id}"></c:if>
		</div>

	
	</sf:form>
	<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>

</body>
</html>