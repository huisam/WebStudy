<%@page import="servlet.Node"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span{
		margin: 10px;
		padding: 10px;
		font-weight: bold;
	}

</style>
</head>
<body>
<h1>상품이 저장되었습니다!!</h1>
<%
	ArrayList<Node> list = (ArrayList)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++){
%>
<div><span>상품 번호</span><%=i+1 %> </div>
<div><span>상품명</span><%=list.get(i).getProductName() %></div>
<div><span>상품 가격</span><%=list.get(i).getPrice() %></div>
<div><span>상품 설명</span><%=list.get(i).getContent() %></div>
<%} %>
<a href="index.html">상품 등록</a><br>
<a href="Product?view=recent">마지막 등록한 상품</a>
</body>
</html>