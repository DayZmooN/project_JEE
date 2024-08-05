<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Catégories</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Gestion des Catégories</h1>

<form action="categories" method="post">
    <h2>Ajouter une nouvelle catégorie</h2>
    <label for="name">Nom de la catégorie:</label>
    <input type="text" id="name" name="name" required>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required>
    <input type="submit" value="Ajouter">
</form>

<!-- Liste des catégories -->
<h2>Liste des catégories</h2>
<table>
    <thead>
    <tr>
        <th>nom</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
    <!-- Boucle à travers les catégories -->
    <c:forEach var="categorie" items="${categories}">
        <tr>
            <td>${categorie.name}</td>
            <td>${categorie.description}</td>
            <td>
            <form action="${pageContext.request.contextPath}/deleteCategories" method="post")>
                <input type="hidden" name="categorieId" value="${categorie.id}">
                <input type="submit" value="Supprimer">
            </form>
            </td>
            <th><a href="${pageContext.request.contextPath}/updateCategorie?id=${categorie.id}">Modifier</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
