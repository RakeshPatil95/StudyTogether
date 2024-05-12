<%@page import="pojos.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From add product : session ID  <%= session.getId() %></h5>
	<%--create product class instance from rq params. --%>
	<%
	Product product = new Product(Integer.parseInt(request.getParameter("pid")), request.getParameter("name"),
			Double.parseDouble(request.getParameter("price")));
	//store product details under sesison scope
	session.setAttribute("product_dtls", product);
	//redirect clnt
	response.sendRedirect("product_details.jsp");
	%>
</body>
</html>