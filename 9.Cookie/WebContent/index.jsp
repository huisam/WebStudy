<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		display: inline-block;
	}
</style>
</head>
<body>
	<h1>상품을 등록 해 주세요.</h1>
	<a ></a>
	<form method="post" action="/hwbackend01/Product">
		<p>
			<span>상품명 : </span>
			<input type="text" name="productName">
		</p>
		<p>
			<span>상품 가격 : </span>
			<input type="text" name="price">
		</p>
		<p>
			<span>상품 설명 : </span>
			<input type="text" name="content">
		</p>
		<input type="submit" value="저장">
		<input type="reset" value="취소">		
	</form>
</body>
</html>