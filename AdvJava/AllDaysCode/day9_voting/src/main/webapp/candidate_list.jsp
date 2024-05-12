<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color: green;">${sessionScope.voter.message}</h5>
	<h5>Logged in under ${sessionScope.voter.userDetails.role}</h5>
	<h3 align="center">Candidate List</h3>
	<h5></h5>
	<form action="status.jsp" method="get">
		<table style="background-color: lightgrey; margin: auto">

			<c:forEach var="c" items="${sessionScope.candidate.allCandidates}">
				<tr>
					<td><input type="radio" name="cId" required
						value="${c.candidateId}" /></td>
					<td>${c.name}</td>
					<td>${c.politicalParty}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Vote" /></td>
			</tr>

		</table>
	</form>
</body>
</html>