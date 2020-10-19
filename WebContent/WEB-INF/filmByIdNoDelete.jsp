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
	
	
	<c:choose>
		<c:when test="${! empty film }">
		<br>
  <form action="updateFilm.do" method="GET">
				<label for="title">Title:</label> <input type="text" name="title"
					value="${film.title }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
		<br>
				<label for="description">Description:</label> <input type="text" name="description"
					value="${film.description }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
	<br>
				<label for="releaseYear">Released:</label> <input type="text" name="releaseYear"
					value="${film.releaseYear }" /> <input type="hidden" name="id"
					value="${film.id }" />
<%-- 				<label for="title">Language ID:</label> <input type="text" name="title"
					value="${film.languageId }" /> <input type="hidden" name="id"
					value="${film.id }" />  --%>

			<br>
				<label for="rentalDuration">Rental Duration:</label> <input type="text" name="rentalDuration"
					value="${film.rentalDuration }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
		<br>
			
				<label for="rentalRate">Rental Cost:</label> <input type="text" name="rentalRate"
					value="${film.rentalRate }" /> <input type="hidden" name="id"
					value="${film.id }" /> 

			<br>
				<label for="replacementCost">Replacement Cost:</label> <input type="text" name="replacementCost"
					value="${film.replacementCost }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
			<br>
						<label for="length">Length:</label> <input type="text" name="length"
					value="${film.length }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
	
			<br>
				<label for="rating">Rating:</label> <input type="text" name="rating"
					value="${film.rating }" /> <input type="hidden" name="id"
					value="${film.id }" /> 
					<br>
					<input type="submit" value="Update" />
			</form>
</c:when>
</c:choose>

	
	<form action="home.do" method="GET">
		<input type="submit" class="button" value="Back" />
	</form>
</body>
</html>


<style type="text/css">
body {
	background: #292929;
	color: #ffffff;
	display: inline-block;
	font-family: 'Lato', sans-serif;
	font-size: 12px;
	font-weight: bold;
	line-height: 12px;
	letter-spacing: 1px;
	margin: 0 0 30px;
	padding: 10px 15px 8px;
}