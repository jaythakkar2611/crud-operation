<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employee List</title>
</head>
<body>
	<a href='Index.jsp'>Add New Employee</a>
	<h1>Employee List</h1>
	<table border='1' style="width: 100%;">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Gender</th>
			<th>Course</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="employee" items="${list}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>${employee.email}</td>
				<td>${employee.contact}</td>
				<td>${employee.gender}</td>
				<td>${employee.course}</td>
				<td><a href='EditServlet?editId=${employee.id}'>Edit</a></td>
				<td><a href='EditServlet?deleteId=${employee.id}'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
