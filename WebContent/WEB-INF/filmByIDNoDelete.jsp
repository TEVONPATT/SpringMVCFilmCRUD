<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film by ID</title>
</head>
<body>
<body>
	<h3>Films by ID</h3>

	<c:choose>
		<c:when test="${not empty film}">
			<ul>
				<strong>Title: ${film.title}</strong>
				<li><em>Description:</em> ${film.description}</li>
				<li><em>Released:</em> ${film.releaseYear}</li>
				<li><em>Langauge ID:</em> ${film.languageId}</li>
				<li><em>Rental Duration:</em> ${film.rentalDuration}</li>
				<li><em>Rental Cost:</em> ${film.rentalRate}</li>
				<li><em>Length of Film:</em> ${film.length}</li>
				<li><em>Replacement Cost:</em> ${film.replacementCost}</li>
				<li><em>Rating:</em> ${film.rating}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film Found</p>
		</c:otherwise>
	</c:choose>
	
	
	<form action="update.do" method="GET">
		<input type="submit" class="button" value="Update this film" />
	</form>
	
	
	<form action="home.do" method="GET">
		<input type="submit" class="button" value="Back" />
	</form>
</body>
</html>