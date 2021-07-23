<%@ page import="com.Employee" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Manager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
<%Employee emp = (Employee)request.getAttribute("emp"); %>
<%Manager mag = (Manager)request.getAttribute("mag"); %>
<h2>Employee Page</h2>
<table>
<tr>
<th>Emp Info</th>
</tr>
<tr>
<th><%=emp.getEmpNo() %></th>
<th><%=emp.getEmpFirstName() %></th>
<th><%=emp.getEmpLastName() %></th>
<th><%=emp.getEmpEmail() %></th>
<th><%=emp.getEmpPhoneNumber() %></th>
<%-- <%int empNo = emp.getEmpNo(); %> --%>
</tr>
</table>
<!--  <a href="/WEB-INF/update.jsp?empNo=${empNo}">Update Information</a>  -->
<form action="updateEmployee" method="get">
<input type="hidden" name="empNo" value="${emp.getEmpNo()}">
<input type="submit" value="Update Employee">
<%-- <%
session.setAttribute("empNo", empNo);
RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateEmployee.jsp");
rd.forward(request, response);
%> --%>
</form>
</br>
<form action="reimbursementClaims" method="get">
<input type="hidden" name="empNo" value="${emp.getEmpNo()}">
<input type="submit" value="Reimbursement Claims">
</form>

<form action="check" method="post">
<input type="submit" value="logout">
</form>
</body>
</html>