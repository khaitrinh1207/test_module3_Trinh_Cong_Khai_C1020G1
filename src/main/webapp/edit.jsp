<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 25/02/2021
  Time: 11:48 SA
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
<h3><a href="/product">Trang Chủ</a></h3>
<h3>Cập nhật sản phẩm</h3>
<form method="post">
    name: <input type="text" name="name_product" placeholder="name_product" value="${product.name}"><br>
    price: <input type="text" name="price_product" placeholder="price_product" value="${product.price}"><br>
    quantity: <input type="text" name="amount_product" placeholder="amount_product" value="${product.amount}"><br>
    color: <input type="text" name="color_product" placeholder="color_product" value="${product.color}"><br>
    description: <input type="text" name="des_product" placeholder="des_product" value="${product.description}"><br>
    category: <input type="text" name="category_id" placeholder="category_id" value="${product.category_id}"><br>
    <input type="submit" value="Edit">
</form>
</body>
</html>
