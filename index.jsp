<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pets</title>
</head>
<body>
<h2>Pet list</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
<tr><th>AnimalName</th><th>AnimalType</th><th>AnimalColor</th><th>AnimalAge</th><th>AnimalHost</th><th></th> </tr>
<c:forEach var="animals" items="${animals}">
<tr><td>${animals.animalName}</td>
<td>${animals.animalType}</td>
<td>${animals.animalColor}</td>
<td>${animals.animalAge}</td>
<td>${animals.animalHost}</td>
<td>
<a href ='<c:url value="/edit?id=${animals.id}" />'>Edit</a> |
<form method="post" action='<c:url value="/delete" />' style="display:inline;">
<input type="hidden" name="id" value="${animals.id}">
<input type="submit" value="Delete">
</form>
</td></tr>
</c:forEach>
</table>
</body>
</html>