<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete film</title>
</head>
<body>
  <h3>Delete films</h3>
  <form action="deleteFilm.do" method="GET">
    Film ID:
    <input type="text" name="name"/> 
    <input type="submit" value="Get Film" />
  </form>
</body>
</html>