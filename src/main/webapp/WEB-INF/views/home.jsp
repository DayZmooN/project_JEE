<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .form-container, .table-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 2rem;
        }
        .truncate {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            max-width: 150px; /* Adjust the width as needed */
        }
        .table-container {
            overflow-x: auto; /* Allow horizontal scrolling for small screens */
        }
    </style>
</head>
<body>
<%@include file="menu.jsp"%>

<div class="container">
    <!-- Form Container -->
    <div class="form-container">
        <h2 class="mb-4">Submit Your Email</h2>
        <form action="${pageContext.request.contextPath}/submitForm" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Table Container -->
    <div class="table-container">
        <h2 class="mb-4">List of Users</h2>
        <c:if test="${not empty usersAll}">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead class="thead-dark">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th class="d-none d-md-table-cell">Password</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${usersAll}">
                        <tr>
                            <td class="truncate">${user.first_name}</td>
                            <td class="truncate">${user.last_name}</td>
                            <td class="truncate">${user.email}</td>
                            <td class="truncate">${user.phone}</td>
                            <td class="truncate d-none d-md-table-cell">${user.password}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/deleteUser" method="post" class="d-inline">
                                    <input type="hidden" name="userId" value="${user.id}">
                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                </form>
                                <a href="${pageContext.request.contextPath}/update?id=${user.id}" class="btn btn-warning btn-sm">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <c:if test="${empty usersAll}">
            <p>No users found.</p>
        </c:if>
    </div>
</div>

<!-- Bootstrap JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Q7BLTAvzxI/baW+cspvxG4m0tv1xErEDelI2zboXqAbmeF+ErE4jGZa3xlXG4lYp" crossorigin="anonymous"></script>
</body>
</html>
