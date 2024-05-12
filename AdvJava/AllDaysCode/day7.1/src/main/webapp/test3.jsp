<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	String mesg;
	int visits;

	//can override life cycle methods from JSP decl block
	public void jspInit() {
		System.out.println("in jsp init : invoked by  " + Thread.currentThread());
		mesg = "some mesg!!!!";
		visits = 1;
	}
	//can override jspDestroy from the same block
	%>
<body>
	<%
	System.out.println("in _jspService : invoked by  " + Thread.currentThread());
	visits++;
	%>
	<h5>
		Visits :
		<%=visits%></h5>
</body>
<%!public void jspDestroy() {
		System.out.println("in jsp destroy : invoked by  " + Thread.currentThread());
	}%>
</html>