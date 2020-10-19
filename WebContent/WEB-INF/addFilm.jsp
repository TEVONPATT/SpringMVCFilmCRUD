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
	<div>
		<h3>Add a film</h3>
		<c:choose>
			<c:when test="${not empty film}">
				<ul>
					
					<li>Film ID: ${film.id}</li>
					<li>Title: ${film.title}</li>
					<li>Description: ${film.description}</li>
					<li>Release year: ${film.releaseYear}</li>
					<li>Language ID: ${film.languageId}</li>
					<li>Rental duration: ${film.rentalDuration}</li>
					<li>Rental rate: ${film.rentalRate}</li>
					<li>Length: ${film.length}</li>
					<li>Replacement cost: ${film.replacementCost}</li>
					<li>Rating: ${film.rating}</li>
				</ul>
			</c:when>
			<c:otherwise>
				<p>Adding film failed.</p>
			</c:otherwise>
		</c:choose>
		<form action="home.do" method="GET">
		<input type="submit" class="button" value="Home Page" />
	</form>
	</div>
	
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