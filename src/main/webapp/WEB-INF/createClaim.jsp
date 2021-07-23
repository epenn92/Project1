<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Reimbursement Claim</title>
</head>
<body>
<h1>Test update</h1>
<h2>Employee Number: <%= request.getParameter("empno") %></h2>

<form action="createClaim" method="post">
<input type="hidden" name="empno" value="${empNo}">
Reimbursement Activity: <input type="text" name="remactivity">
Reimbursement Amount: <input type="number" name="remamount">
<input type="hidden" name="remStatus" value="pending">
</br>
<input type="submit" value="Submit Claim">
</form> 

</body>
</html>