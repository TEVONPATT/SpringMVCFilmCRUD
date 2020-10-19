<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film by Key Word</title>
</head>
<body>
	<h3>Films by Key Word</h3>
	<c:choose>
		<c:when test="${not empty film}">
			<c:forEach items="${film}" var="movie">
				<ul>
					<li>Film ID: <br> <c:out value="${movie.id}" /></li>
					<li>Title: <br> <c:out value="${movie.title}" /></li>
					<li>Description: <br> <c:out value="${movie.description}" />
					</li>
					<li>
					</ul>
					</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No film Found</p>
		</c:otherwise>
	</c:choose>
		<hr>
	<h3>Update film</h3>
	<h4>Please enter the film ID for the film you wish to update/edit.</h4>
	<form action="findFilmByIDEdit.do" method="GET">
		ID: <input type="text" name="filmId" /> <input type="submit"
			value="Get Film" />
	</form>
	<br>
	<form action="deleteFilm.do" method="GET">
    <label for="fname">Delete this film: </label>
       <input type="text" name="filmIdDelete">
       <input type="submit" value="Delete">
       </form>
	
	
</body>


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


