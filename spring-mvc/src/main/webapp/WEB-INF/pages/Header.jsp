<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user}">
		<h3>
			Hi,
			<c:out value="${sessionScope.user.firstName}"></c:out>
		</h3>
		<a href="<c:url value="/ctl/User"/>"><b>Add User</b></a>|
     <a href="<c:url value="/ctl/User/search"/>"><b>User List</b></a>|
     <a href="<c:url value="/LoginView?operation=logout"/>"><b>Logout</b></a>

	</c:if>

	<c:if test="${empty sessionScope.user}">
		<h3>Hi,Guest</h3>
		<a href="Welcome"><b>Welcome</b></a>|
  <a href="LoginView"><b>Login</b></a><!-- |
  <a href="Register"><b>User Registration</b></a> -->

	</c:if>
	<hr>
</body>
</html>