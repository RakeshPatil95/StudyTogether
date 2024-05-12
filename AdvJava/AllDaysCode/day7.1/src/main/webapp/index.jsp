<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From index page : session ID  <%= session.getId() %></h5>
	<h3>
		Welcome 2 JSP @
		<%=LocalTime.now()%></h3>
	<h5>
		<a href="comments.jsp">JSP Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">JSP Scriptlets n Expression n EL Syntax</a>
	</h5>
	<h5>
		<a href="add_product.jsp?pid=101&name=bread&price=50">Add Product</a>
	</h5>
	<h5>
		<a href="test1.jsp">Understanding Scopes in Web App</a>
	</h5>
	<h5>
		<a href="test3.jsp">JSP Declarations</a>
	</h5>
	
</body>
</html>