<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--first WC chks with session.getAttribute("voter") : rets null : session.setAttribute("voter",new VoterBean()) --%>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session"/>
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session"/>
<body>
<h5 style="color: red;">${sessionScope.voter.message}</h5>
	<form action="validate.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" required /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>