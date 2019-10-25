<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<center>
			<form action="add"><br/><br/><br/>
				<h2>Add new student here....<br/><br/></h2>
				<table>
					<tr><td>Student ID : </td><td><input type="text" name="id" value=" <%= request.getParameter("max") %>" readonly="readonly"></td></tr>
					<tr><td>Student Name : </td><td><input type="text" name="name"></td></tr>
					<tr><td>Student age : </td><td><input type="text" name="age"></td></tr>
				</table>
				<input type="submit" value="Insert"><br>
			</form>
		</center>
	</body>
</html>
