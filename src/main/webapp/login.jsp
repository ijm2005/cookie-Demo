<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: red">${errorMsg }</h2>
<form action="login">
<input type="text" name="uname" placeholder="Enter Username=">
<input type="text" name="password" placeholder="Enter Password=">
<input type="submit" value="LOGIN">



</form>
</body>
</html>