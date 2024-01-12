<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<style type="text/css"></style>

</head>
<body>
	<h1 align="center">Employee Form!</h1>
	<form action="SavePage" method="post" >
	<div align="center">
		<table>

			<tr>
				<td></td>
				<td><input type='hidden' name='id' value="${employee.id}" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"
					value="${employee.firstName}" required /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					value="${employee.lastName}" required /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${employee.email}" required /></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="tel" name="contact" maxlength="10" minlength="10"
					value="${employee.contact}" required /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male"
					value="${employee.gender}"
					${employee.gender == "male" ? "checked" : ""} required /><label for="male">MALE</label>
					<input type="radio" name="gender" value="female"
					value="${employee.gender}"
					${employee.gender == "female" ? "checked" : ""} required/><label
					for="female">FEMALE</label></td>
			<tr>
				<td>Course:</td>
				<td><select name="course" style="width: 150px">
						<option ${employee.course == "MSC" ? "selected" : ""}>MSC</option>
						<option ${employee.course == "BE" ? "selected" : ""}>BE</option>
						<option ${employee.course == "ME" ? "selected" : ""}>ME</option>
						<option ${employee.course == "Other" ? "selected" : ""}>Other</option>
				</select></td>
			</tr>
			<tr>

				<td><input type="submit" value="Submit" style="color: green" /></td>

				<td><input type="reset" value="Reset"
					style="color: red; float: right" /></td>
			</tr>
		</table>
		</div>
	</form>
	<br />
	
	<div align="center">
		<a href='ViewServlet'>View Details</a>
	</div>


</body>
</html>