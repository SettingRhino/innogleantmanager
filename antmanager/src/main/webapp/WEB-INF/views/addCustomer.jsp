<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Add Customer</h1>
		<p class="lead"> Fill the below information to add a customer: </p>
		
		<sf:form action="${pageContext.request.contextPath}/customers/addCustomerAfter"
			method="get" modelAttribute="customers" enctype="multipart/form-data">
		
			<div class="form-group">
				<label for="customer_name">손님 성명 : </label>
				<sf:input path="customer_name" id="customer_name" class="form-control" />
				<sf:errors path="customer_name" cssStyle="color:#ff0000;"/>
			</div>
			
			<div class="form-group">
				<label for="customer_character">손님 특징 : </label>
				<sf:input path="customer_character" id="customer_character" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="customer_etc">기타사항 : </label>
				<sf:input path="customer_etc" id="customer_etc" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			
			<a href="<c:url value="/customers" />" class="btn btn-dark">Cancel</a>
		</sf:form>
		<br/>
	</div>
</div>