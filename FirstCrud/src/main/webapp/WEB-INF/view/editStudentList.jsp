<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<html>

<body><center>

    <h3>Update Product</h3>
    <s:form method="post" modelAttribute="student"
            action="${pageContext.request.contextPath }/save">
        <table border="0" cellpadding="2" cellspacing="2">
            <tr>
                <td>Id</td>
                <td>
                    <s:input path="id"/>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <s:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <s:input path="age"/>
                </td>
            </tr>

                <td>&nbsp;&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </s:form>

<br>
<br>
<br>
<br>
<h3>Students</h3>
<c:if  test="${!empty studentList}">
<table class="data" border="1">
<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Age</th>
    <th>Delete</th>
</tr>
<c:forEach items="${studentList}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <th><a href="/delete${student.id}">Delete</a></th>
    </tr>
</c:forEach>
</table>
</c:if></center>

</body>
</center>
</html>