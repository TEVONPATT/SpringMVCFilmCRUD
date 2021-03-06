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
			<em>Title:</em>${film.title}
			<br>
				<em>Film ID:</em> ${film.id}
				<br>
				<em>Description:</em> ${film.description}
				<br>
				<em>Actors:</em>
				
				<c:forEach items="${film.actors}" var="actors">
				<ul>
				
  <li> ${actors.firstName }  ${actors.lastName }  </li>
</ul>

    
</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film Found</p>
		</c:otherwise>
	</c:choose>
	
	<form action="deleteFilm.do" method="GET">
    <label for="fname">Delete this film: </label>
       <input type="radio" name="filmIdDelete" value="${film.id}">YES
 <br>
       <input type="submit" value="Delete">
       </form>
       <br>
       <form action="home.do" method="GET">
		<input type="submit" class="button" value="Home Page" />
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