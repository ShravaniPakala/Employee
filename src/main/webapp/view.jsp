<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="deloitte"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<th>Employee ID</th>
<th>Employee Name</th>
<th>Employee Address</th>
<th>Link</th>
<deloitte:forEach items="${requestScope.listofEmployees}" var="employee">
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.address}</td>
<td><a href="">delete</a></td>
</tr>
</deloitte:forEach>

</table>

</body>
</html>