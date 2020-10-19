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
			<c:otherwise>
				<p>Adding film failed.</p>
			</c:otherwise>
		</c:choose>
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