<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-wrapper">
<div class="container">
  <h2>Product Inventory</h2>
  <p>제품 재고 현황입니다.</p>            
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
</div>