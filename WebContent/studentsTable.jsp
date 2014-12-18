<%@ page
	import="control.ioLocalStorage.ioType.IOSQL, java.util.*, entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/college" user="root" password="root" />

	<sql:query dataSource="${snapshot}" var="result">
    SELECT students.idStudent, students.firstName,students.lastName, groups.groupName FROM groups INNER JOIN students ON students.idGroup = groups.idGroup WHERE groups.idGroup = 1;
	</sql:query>
	<table border=1 cellpadding=0 cellspacing=0 width=auto>
		<tr>
			<td>&nbsp;ID</td>
			<td>&nbsp;First Name</td>
			<td>&nbsp;Last Name</td>
			<td>&nbsp;Group</td>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.idStudent}" /></td>
				<td><c:out value="${row.firstName}" /></td>
				<td><c:out value="${row.lastName}" /></td>
				<td><c:out value="${row.groupName}" /></td>
			</tr>
			</c:forEach>
	</table>
	<br>
	<input type="text" name="idGroup">
	<input type="text" name="groupName">
</body>
</html>