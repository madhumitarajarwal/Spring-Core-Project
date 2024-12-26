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
<title>Welcome to Registration Page</title>
</head>

<body>
  <%-- <%@ include file="Header.jsp"%> --%>
   <sf:form method="post" modelAttribute="form">
   <div align="center">
   <h1 style ="color:navy">User Registration</h1>
   <table>
     <tr>
      <th align="left">First Name :</th>
      <td><sf:input path="firstName"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="firstName" cssClass="error"></sf:errors></font></td>
    </tr>
    <tr>
      <th align="left">Last Name :</th>
      <td><sf:input path="lastName"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="lastName" cssClass="error"></sf:errors></font></td>
    </tr>
    <tr>
      <th align="left">Login Id :</th>
      <td><sf:input path="login"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="login" cssClass="error"></sf:errors></font></td>
    </tr>
    
    <tr>
      <th align="left">Password :</th>
      <td><sf:input path="password"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="password" cssClass="error"></sf:errors></font></td>
    </tr>
    
    <tr>
      <th align="left">Date of Birth :</th>
      <td><sf:input path="dob"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="dob" cssClass="error"></sf:errors></font></td>
    </tr>
    
    <tr>
      <th align="left">Address:</th>
      <td><sf:input path="address"/></td>
      <td style="position:fixed"><font color="red"><sf:errors path="address" cssClass="error"></sf:errors></font></td>
    </tr>
    
    <tr><th></th>
    <td><input type="submit" name="operation" value="signUp"> </td></tr>
   
   </table>
   </div>
   </sf:form>
</body>
</html>