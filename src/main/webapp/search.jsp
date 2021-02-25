<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 25/02/2021
  Time: 11:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3><a href="/product">Trang chủ</a></h3>
<div>
    <caption>List Products</caption>
    <table border="1">
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${productList2}" var="p">
            <tr>
                <td><c:out value="${p.id}"></c:out></td>
                <td><c:out value="${p.name}"></c:out></td>
                <td><c:out value="${p.price}"></c:out></td>
                <td><c:out value="${p.amount}"></c:out></td>
                <td><c:out value="${p.color}"></c:out></td>
                <td><c:out value="${nameCategory}"></c:out></td>
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
