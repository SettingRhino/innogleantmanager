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
	<!--
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">설명 큰글씨</h1>
  <p class="lead">여기는 간략한 설명 정도 어떨까 합니다.</p>
</div>
-->
	<div class="container-wrapper">
		<div class="container">
			<h1>단골 손님 수정</h1>
			<p class="lead">단골 손님 정보를 수정하세요 :</p>

			<sf:form
				action="${pageContext.request.contextPath}/customers/updateCustomerAfter"
				method="post" modelAttribute="customers">


				<sf:hidden path="id" />
				<div class="form-group">
					<label for="customer_name">손님 성명 : </label>
					<sf:input path="customer_name" id="customer_name"
						class="form-control" />
					<sf:errors path="customer_name" cssStyle="color:#ff0000;" />
				</div>

				<div class="form-group">
					<label for="customer_character">손님 특징 : </label>
					<sf:input path="customer_character" id="customer_character"
						class="form-control" />
				</div>

				<div class="form-group">
					<label for="customer_etc">기타사항 : </label>
					<sf:textarea path="customer_etc" id="customer_etc"
						class="form-control" />
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>

				<a href="<c:url value="/customers" />" class="btn btn-dark">Cancel</a>
			</sf:form>
			<br />
		</div>
	</div>

	<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>
	</div>
</body>
</html>



