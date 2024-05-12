<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 style="color: green;">${sessionScope.voter.message}</h5>
<h5> Logged in under ${sessionScope.voter.userDetails.role}</h5>
<%--invalidate Http Session --%>
	${pageContext.session.invalidate()}
</body>
</html>