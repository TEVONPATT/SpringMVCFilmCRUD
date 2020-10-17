<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film by ID</title>
</head>
<body>
  <h3>Films by ID</h3>
  <form action="GetStateData.do" method="GET">
    ID:
    <input type="text" name="name"/> 
    <input type="submit" value="Get Film" />
  </form>
</body>
</html>