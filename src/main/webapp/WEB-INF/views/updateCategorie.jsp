<!DOCTYPE html>
<html>
<head>
    <title>Update Category</title>
</head>
<body>
<h1>Update Category</h1>
<form action="${pageContext.request.contextPath}/updateCategorie" method="post">
    <input type="hidden" name="id" value="${category.id}" />
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${category.name}" required /><br/>
    <label for="description">Description:</label>
    <input type="text" name="description" id="description" value="${category.description}" required /><br/>
    <input type="submit" value="Update Category" />
</form>
</body>
</html>
