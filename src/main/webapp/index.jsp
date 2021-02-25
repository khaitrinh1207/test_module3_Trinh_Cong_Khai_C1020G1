<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 25/02/2021
  Time: 9:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>End_module3_Trịnh Công Khải</title>
</head>
<body>
<div>
    <h2><a href="/product?action=create">Thêm mới sản phẩm</a></h2>
</div>
<div>
    <form action="/product?action=search" method="post">
      <input type="search" name="search" placeholder="search">
      <input type="submit" value="submit">
    </form>
</div>
<div align="center">
  <caption><h2>List Products</h2></caption>
  <table border="1">
    <tr>
      <th>#</th>
      <th>Product Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Color</th>
      <th>Description</th>
      <th>Category</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${productList}" var="p">
      <tr>
        <td><c:out value="${p.id}"></c:out></td>
        <td><c:out value="${p.name}"></c:out></td>
        <td><c:out value="${p.price}"></c:out></td>
        <td><c:out value="${p.amount}"></c:out></td>
        <td><c:out value="${p.color}"></c:out></td>
        <td><c:out value="${p.description}"></c:out></td>
        <td><c:out value="${p.category_id}"></c:out></td>
        <td>
          <a href="/product?action=edit&id=${p.id}">Sửa</a>
          <a href="/product?action=delete&id=${p.id}">Xóa</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
