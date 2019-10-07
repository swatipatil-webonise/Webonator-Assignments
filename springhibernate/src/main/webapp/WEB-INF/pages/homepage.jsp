<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Welcome to Student Application</h1>
    <br>
    <a href="/newStudent">Add new Student</a>
    <br><br>
    <table border="1">
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Telephone</th>
        <th>Edit</th>
        <th>Delete</th>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.address}</td>
                <td>${student.telephone}</td>
                <td><a href="/editStudent?id=${student.id}">Edit</a></td>
                <td><a href="/deleteStudent?id=${student.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>