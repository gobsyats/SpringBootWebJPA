<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringBoot Web JPA H2</title>
</head>
<body>
	<form action = "addAlien">
		Enter ID: <input type = "text" name = "aid"><br>
		Enter Name: <input type = "text" name = "aname"><br>
		Enter Tech: <input type = "text" name = "tech"><br>
		<input type = "submit"><br>
	</form>
	<br><br>
	<form action = "getAlien">
		<input type = "text" name = "aid"><br>
		<input type = "submit"><br>
	</form>
</body>
</html>