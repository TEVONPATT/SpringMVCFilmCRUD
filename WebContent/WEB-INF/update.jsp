<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update/Edit film</title>
</head>
<body>
	Please enter which you would like to update:
  
<c:choose>
		<c:when test="${! empty film }">
		<br>
  <form action="updateFilm.do" method="POST">
				<label for="title">Title:</label> <input type="text" name="title"
					value="${film.title }" /> <input type="hidden" name="id"
					value="${film.id }" /> <input type="submit" value="Update" />
			</form>
</c:when>
</c:choose>


</body>
</html>