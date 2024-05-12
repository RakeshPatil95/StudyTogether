<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
	//scriptlet 
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	out.write("<h4> Email " + email + "</h4>");
	out.write("<h4> PWD " + password + "</h4>");
	%> --%>
	<h3>Via JSP Scriptlets</h3>
	<h4>
		Email :
		<%
	out.write(request.getParameter("em"));
	%>
	</h4>
	<h4>
		Password :
		<%
	out.write(request.getParameter("pass"));
	%>
	</h4>
	<hr />
	<h3>Via JSP Expressions</h3>
	<h4>
		Email :
		<%=request.getParameter("em")%></h4>
	<h4>
		Password :
		<%=request.getParameter("pass")%></h4>
	<hr />
	<h3>Via JSP EL Syntax</h3>
	<h4>Email : ${param.em}</h4>
	<h4>PWD : ${param.pass}</h4>
	<h4>Param : ${param}</h4>

</body>
</html>