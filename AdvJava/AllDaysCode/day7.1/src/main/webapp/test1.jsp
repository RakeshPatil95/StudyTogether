<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page....</h5>
	<%-- add 4 different attributes under varying scopes page request session application --%>
	<%
	pageContext.setAttribute("nm1", 1234);
	request.setAttribute("nm2", 2234);
	session.setAttribute("nm3", 3234);
	application.setAttribute("nm4", 4234);
	//navigate the clnt to the next page in the SAME request : forward
	/* 	RequestDispatcher rd=request.getRequestDispatcher("test2.jsp");
		rd.forward(request, response);	
	 */
	//replace server pull by Client Pull -- redirect scenario
	response.sendRedirect("test2.jsp");
	%>
</body>
</html>