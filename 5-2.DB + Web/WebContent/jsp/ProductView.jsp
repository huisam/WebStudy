<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>상세 안내 페이지</title>
</head>
<body>
	<div class="container">
		<h1 align="center">제품 상세 정보</h1>
		<table class="table table-bordered table-striped">
			<tr>
				<th>제품 번호</th>
				<th>제품명</th>
				<th>종류</th>
				<th>제조사</th>
				<th>가격(원)</th>
			</tr>
			<c:choose>
				<c:when test="${not empty product }">
					<tr>
						<td>${product.isbn }</td>
						<td>${product.title }</td>
						<td>${product.kind }</td>
						<td>${product.maker }</td>
						<td>${product.price }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<td colspan="5" align="center">자료가 없습니다 ㅠㅠ</td>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="3" align="center">
					<a href="ProductList.do">제품리스트</a>
				</td>
				<td align="center">
					<a href="ProductModifyReady.do?isbn=${product.isbn }">제품 수정</a>
				</td>
				<td align="center">
					<a href="ProductDelete.do?isbn=${product.isbn }">제품 삭제</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>