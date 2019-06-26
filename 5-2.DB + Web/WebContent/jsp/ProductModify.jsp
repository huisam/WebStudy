<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h1 align="center">제품 상세 정보</h1>
	<form action="ProductModify.do" method="post">
				<fieldset>
					<legend>상품정보</legend>
						상품번호 :<label><input type="text" id="isbn" name="isbn" value="${product.isbn }" readonly="readonly" /></label><br>
						상품명 : <label><input type="text" id="title" name="title" value="${product.title }" /></label><br>
						종류 : <label><input type="text" id="kind" name="kind" value="${product.kind }" /></label><br>
						제조사 : <label><input type="text" id="maker" name="maker" value="${product.maker}" /></label><br>
						가격(원) <label><input type="text" id="price" name="price" value="${product.price}" /></label><br>
					<input type="submit" value="수정">
			</fieldset>
	</form>
		<a href="ProductList.do">제품리스트</a><br>
		<a href="ProductDelete.do?isbn=${product.isbn }">제품 삭제</a>
	</div>
</body>
</html>