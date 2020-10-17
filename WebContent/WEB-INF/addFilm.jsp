<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add film</title>
</head>
<body>
	<h3>Add a film</h3>

	<c:choose>
		<c:when test="${not empty film}">
			<ul>
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.release_year}</li>
				<li>${film.language_id}</li>
				<li>${film.rental_duration}</li>
				<li>${film.rental_rate}</li>
				<li>${film.length}</li>
				<li>${film.replacement_cost}</li>
				<li>${film.rating}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Adding film failed.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>