<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add film</title>
</head>
<body>
	<h3>Add a film</h3>

	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.languageId}</li>
				<li>${film.rentalDuration}</li>
				<li>${film.rentalRate}</li>
				<li>${film.length}</li>
				<li>${film.replacementCost}</li>
				<li>${film.rating}</li>
			</ul>
		</c:when> 
		<!--NOT DISPLAYING-->
		<c:otherwise>
			<p>Adding film failed.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>