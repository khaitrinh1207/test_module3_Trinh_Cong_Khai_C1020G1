<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 25/02/2021
  Time: 12:37 CH
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
<h3>Thêm mới sản phẩm</h3>
<form method="post">
    name: <input type="text" name="name_product2" placeholder="name_product"><br>
    price: <input type="text" name="price_product2" placeholder="price_product"><br>
    quantity: <input type="text" name="amount_product2" placeholder="amount_product"><br>
    color: <input type="text" name="color_product2" placeholder="color_product"><br>
    description: <input type="text" name="des_product2" placeholder="des_product"><br>
    category: <input type="text" name="category_id2" placeholder="category_id"><br>
    <input type="submit" value="Insert">
</form>
</body>
</html>
