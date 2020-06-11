<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
  
     <div class="container">
     <p align="center"><a href="<c:url value="/"/>" class="btn btn-primary" role="button">처음으로</a></p>
      <form class="form-signin" method="post" action="<c:url value="/login"/>">
        <h2 class="form-signin-heading">로그인해주세요</h2>
        <a class="text-success">${pwupdateok}</a>
        <p>
          <label for="username" class="sr-only">이름</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">비밀번호</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
		
<sec:csrfInput/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
        <a href="<c:url value="/user/forgetpassword"/>" class="btn btn-lg btn-primary btn-block">비밀번호찾기</a>
      </form>
      
</div>
</body></html>