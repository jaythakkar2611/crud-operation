<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employee List</title>
</head>
<body>
	<a href='Index.jsp'>Add New Employee</a>
	<h1>Employee List</h1>


	<table  border='1' style="width: 100%;">
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

		

		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.firstName}</td>
				<td>${list.lastName}</td>
				<td>${list.email}</td>
				<td>${list.contact}</td>
				<td>${list.gender}</td>
				<td>${list.course}</td>
				<td><a href='EditServlet?editId=${list.id}'>Edit</a></td>
				<td><a href='EditServlet?deleteId=${list.id}'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
