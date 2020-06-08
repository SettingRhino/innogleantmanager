<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-wrapper">
<div class="container">
  <h2>단골 손님 리스트</h2>
  <p>단골 손님 리스트을 보고 추가, 수정, 삭제를 쉽게 하세요~</p>            
  <table class="table table-striped">
    <thead>
      <tr class="bg-success">
      	<th>Customer Name</th>
        <th>Customer Character</th>
        <th>Customer Etc</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="customer" items="${customers}">
      	<tr>
      		<td> ${customer.customerName} </td>
      		<td> ${customer.customerCharacter} </td>
      		<td> ${customer.customerEtc} </td>
      		<td> <a href="<c:url value="/viewCustomer/${customer.id}" />"><i class="fas fa-info-circle"></i></a></td>
      	</tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</div>