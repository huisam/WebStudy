<%@page import="java.awt.print.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<!-- 만약에 EL JSTL 이 없다면 -->
	<div class="container">
		<h1 align="center">제품 목록들</h1>
		<table class="table table-bordered table-striped">
			<tr>
				<th>제품 번호</th>
				<th>제품명</th>
				<th>종류</th>
				<th>제조사</th>
				<th>가격(원)</th>
			</tr>
			<c:choose>
				<c:when test="${not empty productList }">
					<c:forEach items="${productList }" var="product">
						<tr>
							<td>
								<a href="ProductDetail.do?isbn=${product.isbn }">${product.isbn }</a>
							</td>
							<td>${product.title }</td>
							<td>${product.kind }</td>
							<td>${product.maker }</td>
							<td>${product.price }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<td colspan="5" align="center">자료가 없습니다 ㅠㅠ</td>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5" align="right">
					<a href="ProductAddReady.do">제품추가</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>