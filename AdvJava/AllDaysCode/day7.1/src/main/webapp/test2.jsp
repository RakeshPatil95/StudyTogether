<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From 2nd page....</h5>
<%--Display attributes  --%>
<h5>Page Scoped Attribute : ${pageScope.nm1}</h5>
<h5>Request Scoped Attribute : ${requestScope.nm2}</h5>
<h5>Session Scoped Attribute : ${sessionScope.nm3}</h5>
<h5>Application Scoped Attribute : ${applicationScope.nm4}</h5>

<h5>Page : <%= page %></h5>
<h5> pageContext <%= pageContext %></h5>
<h5> pageScope ${pageScope}</h5>
</body>
</html>