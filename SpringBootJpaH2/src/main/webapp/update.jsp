<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="updateStudent"><br/><br/><br/>
			<h2>Update student here....<br/><br/></h2>
			<table>
			<tr><td>Student ID : </td><td><input type="text" name="id" value="${student.id }" readonly="readonly"></td></tr>
			<tr><td>Student Name : </td><td><input type="text" name="name" value="${student.name }"></td></tr>
			<tr><td>Student age : </td><td><input type="text" name="age" value="${student.age }"></td></tr>
			</table>
			<input type="submit" value="Update"><br>
		</form>
	</center>
</body>
</html>