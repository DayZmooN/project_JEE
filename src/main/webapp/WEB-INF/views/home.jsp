<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<%@include file="menu.jsp"%>


<form action="${pageContext.request.contextPath}/submitForm" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <input type="submit" value="Submit">
</form>


    <h1>List of Users</h1>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${usersAll}">
            <tr>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.password}</td>
                <td>
                <form action="${pageContext.request.contextPath}/deleteUser" method="post")>
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Supprimer">
                </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
