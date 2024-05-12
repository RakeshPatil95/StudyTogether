<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--http://localhost:8080/day9_voting/status.jsp?cId=4 --%>
<jsp:setProperty property="*" name="candidate" />
<body>
	<h5>Hello, ${sessionScope.voter.userDetails.name}</h5>
	<c:choose>
		<c:when test="${!sessionScope.voter.userDetails.status}">
			<h5>${sessionScope.candidate.incrementVotes()}</h5>
			<h5>${sessionScope.voter.updateVotingStatus()}</h5>
		</c:when>
		<c:otherwise>
		${sessionScope.voter.message}
		</c:otherwise>
	</c:choose>

	<h5>You have logged out....</h5>	
	<%--invalidate Http Session --%>
	${pageContext.session.invalidate()}

</body>
</html>