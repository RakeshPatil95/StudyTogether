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
	<%-- <h5>All dept names : </h5> --%>
	<form action="employee/list" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Department</td>
				<td><select name="deptName">
						<c:forEach var="nm" items="${requestScope.dept_names}">
							<option value="${nm}">${nm}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose Department" /></td>
			</tr>
		</table>
	</form>
</body>
</html>