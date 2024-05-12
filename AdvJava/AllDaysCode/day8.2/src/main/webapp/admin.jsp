<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>Login Successful , Hello
		${sessionScope.user.validatedUserDetails.name}</h5>
	<h5>You have logged in as
		${sessionScope.user.validatedUserDetails.role}</h5>
</body>
</html>