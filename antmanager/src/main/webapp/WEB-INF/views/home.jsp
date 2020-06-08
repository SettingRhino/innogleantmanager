

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
  <nav class="my-2 my-md-0 mr-md-3">
    <a class="p-2 text-dark" href="#">삭제할지...</a>
    <a class="p-2 text-dark" href="#">삭제할지..</a>
    <a class="p-2 text-dark" href="#">삭제할지.</a>
    
    <a class="p-2 text-dark" href="<c:url value="/test"/>">삭제할지</a>
  </nav>
  <a class="btn btn-outline-primary" href="<c:url value="/user/signup"/>">회원가입</a>
  <a class="btn btn-outline-primary" href="<c:url value="/login"/>">로그인</a>
  <a class="btn btn-outline-primary" href="<c:url value="/logout"/>">로그아웃</a>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">설명 큰글씨</h1>
  <p class="lead">여기는 간략한 설명 정도 어떨까 합니다.</p>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">제목</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">큰글씨</h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>설명1</li>
          <li>설명2</li>
          <li>설명3</li>
          <li>설명4</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary"href="#">등록하기</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">제목2</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">큰글씨2</h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>설명1</li>
          <li>설명2</li>
          <li>설명3</li>
          <li>설명4</li>
        </ul>
        <a href="<c:url value="/customers" />"><button type="button" class="btn btn-lg btn-block btn-primary" >손님 등록</button></a>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">제목3</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">큰글씨3</h1>
        <ul class="list-unstyled mt-3 mb-4">
       <li>설명1</li>
          <li>설명2</li>
          <li>설명3</li>
          <li>설명4</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary"href="#">이동하기</button>
      </div>
    </div>
  </div>

  <footer class="pt-4 my-md-5 pt-md-5 border-top">
  <!-- 
    <div class="row">
      <div class="col-12 col-md">
        <img class="mb-2" src="/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="24" height="24">
        <small class="d-block mb-3 text-muted">&copy; 2017-2020</small>
      </div>
      <div class="col-6 col-md">
        <h5>Features</h5>
        <ul class="list-unstyled text-small">
          <li><a class="text-muted" href="#">Cool stuff</a></li>
          <li><a class="text-muted" href="#">Random feature</a></li>
          <li><a class="text-muted" href="#">Team feature</a></li>
          <li><a class="text-muted" href="#">Stuff for developers</a></li>
          <li><a class="text-muted" href="#">Another one</a></li>
          <li><a class="text-muted" href="#">Last time</a></li>
        </ul>
      </div>
      <div class="col-6 col-md">
        <h5>Resources</h5>
        <ul class="list-unstyled text-small">
          <li><a class="text-muted" href="#">Resource</a></li>
          <li><a class="text-muted" href="#">Resource name</a></li>
          <li><a class="text-muted" href="#">Another resource</a></li>
          <li><a class="text-muted" href="#">Final resource</a></li>
        </ul>
      </div>
      <div class="col-6 col-md">
        <h5>About</h5>
        <ul class="list-unstyled text-small">
          <li><a class="text-muted" href="#">Team</a></li>
          <li><a class="text-muted" href="#">Locations</a></li>
          <li><a class="text-muted" href="#">Privacy</a></li>
          <li><a class="text-muted" href="#">Terms</a></li>
        </ul>
      </div>
    </div> -->
  </footer>
</div>
</body>
</html>