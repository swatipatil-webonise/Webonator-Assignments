<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<div align="center">
		<h1>Welcome to student crud app..</h1>
		<br> <a href="/insert.jsp?max=${max}">Add new student</a><br><br>
		<table border="1">
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete</th>
			<c:forEach var="student" items="${list}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td><a href="/getStudent?id=${student.id}">Update</a></td>
					<td><a href="/deleteStudent?id=${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>