<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page</title>
</head>
<body>
${requestScope.msg}
<form action="EmployeeRegistrationServlet" method="post">
employee ID:<input type="number" name="eid" ><br>
employee Address:<input type="text" name="eaddress"><br>
employee Name:<input type="text" name="ename"><br>
<input type="submit" value="register"/>
</form>
</body>
</html>