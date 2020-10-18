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
	<h3>Films by ID</h3>

	<c:choose>
		<c:when test="${not empty film}">
			<ul>
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.id}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film Found</p>
		</c:otherwise>
	</c:choose>
	
	<form action="deleteFilm.do" method="GET">
    <label for="fname">Delete this film: </label>
       <input type="radio" name="filmIdDelete" value="${film.id}">YES
       <input type="radio" name="filmIdDelete" value="NO">NO
 <br>
       <input type="submit" value="${film.id}">
       </form>
</body>
</html>