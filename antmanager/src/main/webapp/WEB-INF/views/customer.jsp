<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">단골 손님</h1>
  <p class="lead">단골 손님 정보를 추가, 수정, 삭제</p>
</div>

<div class="container">
<table class="table table-striped">
    <thead>
      <tr class="bg-success">
      	<th>손님 이름</th>
        <th>손님 특징</th>
        <th>기타사항</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="customer" items="${customers}">
      	<tr>
      		<td> ${customer.customer_name} </td>
      		<td> ${customer.customer_character} </td>
      		<td> ${customer.customer_etc} </td>
      		<td>
      			<a href="<c:url value="/customers/deleteCustomer/${customer.id}"/>"><button>삭제</button></a>
      			<a href="<c:url value="/customers/updateCustomer/${customer.id}"/>"><button>수정</button></a>
      		</td>
      	</tr>
      </c:forEach>
    </tbody>
  </table>
	<a href="<c:url value="/customers/addCustomer"/>" class="btn btn-primary"> Add Product </a> 
	</div>
  <footer class="pt-4 my-md-5 pt-md-5 border-top">
</footer>
</div>
</body>
</html>