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
      	<th>Photo Thumb</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>UnitInStock</th>
        <th>Description</th>
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
      			<a href="<c:url value="/admin/productInventory/deleteProduct/${product.id}"/>">
      				<i class="fas fa-times-circle"></i></a>
      			<a href="<c:url value="/admin/productInventory/updateProduct/${product.id}"/>">
      				<i class="fas fa-edit"></i></a>
      		</td>
      	</tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="<c:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary"> Add Product </a> 
</div>
</div>