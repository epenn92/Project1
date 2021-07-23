<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<h1>Test update</h1>
<% int empNo = (Integer)request.getAttribute("empNo"); %>
<h2>Employee Number: <%=empNo %></h2>

<form action="updateEmployee" method="post">
<input type="hidden" name="empno" value="${empNo}">
First Name: <input type="text" name="firstname">
Last Name: <input type="text" name="lastname">
Email: <input type="text" name="email">
Phone Number: <input type="text" name="phonenumber">

<input type="submit" value="Submit Update">
</form> 

</body>
</html>