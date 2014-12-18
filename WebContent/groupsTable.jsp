<%@ page
	import="control.ioLocalStorage.ioType.IOSQL, java.util.*, entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups Table</title>
</head>
<body>
	<form action="/CollegeWEB/updateGroup" method="GET">
		<table border=1 cellpadding=0 cellspacing=0 width=auto>
			<tr>
				<td>&nbsp;ID</td>
				<td>&nbsp;GroupName</td>
			</tr>
			<c:forEach var="group" items="${Groups}">
				<tr>
					<td>&nbsp;${group.idGroup}</td>
					<td>&nbsp;<a href="/CollegeWEB/studentsTable.jsp?idGroup=${group.idGroup}">${group.groupName}</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="text" name="idGroup"></td>
				<td><input type="text" name="groupName"></td>
			</tr>
		</table>
		<input type="radio" name="job" value="add" checked> Add 
		<input type="radio" name="job" value="update"> Update
		<input type="radio" name="job" value="remove"> Remove
		<input type="submit" value="Send" />
	</form>
</body>
</html>