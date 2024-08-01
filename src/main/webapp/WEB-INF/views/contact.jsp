<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Users</title>
</head>
<body>
<%@include file="menu.jsp"%>

<h1>Submit User Information</h1>
<form action="${pageContext.request.contextPath}/register" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="first_name" required><br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="last_name" required><br>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Submit">
</form>

<h1>List of Users</h1>
<c:if test="${not empty users}">
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty users}">
    <p>No users found.</p>
</c:if>
</body>
</html>
