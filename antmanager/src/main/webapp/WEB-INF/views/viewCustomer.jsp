<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Pricing example · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/pricing/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
   
    <link href= "<c:url value="/resources/css/pricing.css"/>" rel="stylesheet">
  </head>
  <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
  <h5 class="my-0 mr-md-auto font-weight-normal">회사이름???</h5>
<a class="btn btn-outline-primary" href="<c:url value="/user/signup"/>">회원가입</a>
  <a class="btn btn-outline-primary" href="<c:url value="/login"/>">로그인</a>
  <a class="btn btn-outline-primary" href="<c:url value="/logout"/>">로그아웃</a>
</div>


<div class="container-wrapper">
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h2>단골 손님 상세 페이지</h2>
			<p>단골손님 내용을 상세히 볼 수 있어요!</p>
		</div>

		<div class="col-md-6">
			<h3>${customer.customer_name}</h3>
			<hr>
			<p>${customer.customer_character}</p>
			<p><strong> 기타 사항: </strong><br/> ${customer.customer_etc}</p>
		</div>
	</div>
</div>
<a href="<c:url value="/customers" />" class="btn btn-dark">취소</a>
</div>


  <footer class="pt-4 my-md-5 pt-md-5 border-top">
</footer>
</div>
</body>
</html>




