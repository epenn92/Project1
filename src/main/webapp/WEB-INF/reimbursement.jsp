<%@ page import="com.ReimbursementRequest" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Reimbursement Page</title>
</head>
<body>
<h1>Test for reimbursement claims</h1>
<%-- <%ArrayList<ReimbursementRequest> remClaims = (ArrayList<ReimbursementRequest>)request.getAttribute("remClaims"); %>
 --%>
<h3>Pending claims: </h3>
<%ArrayList<ReimbursementRequest> pendingClaims = (ArrayList<ReimbursementRequest>)request.getAttribute("pendingClaims"); %>
 <% for(int i=0;i<pendingClaims.size();i++){
   out.println(pendingClaims.get(i));
 } %>
<h3>Resolved Claims:</h3>
<% ArrayList<ReimbursementRequest> resolvedClaims = (ArrayList<ReimbursementRequest>)request.getAttribute("resolvedClaims"); %>
 <% for(int i=0;i<resolvedClaims.size();i++){
   out.println(resolvedClaims.get(i));
 } %>
<h3>Create new Claim:</h3>
<form action="createClaim" method="get">
<input type="hidden" name="empno" value="${empNo}">
<input type="submit" value="Create new Claim">
</form>
</body>
</html>