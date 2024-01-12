package com.ignek.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.constance.EmployeeConstance;
import com.ignek.crud.dao.EmployeeDao;
import com.ignek.crud.dto.Employee;

/**
 * Servlet implementation class SavePage
 */
@WebServlet("/SavePage")
public class SavePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter(EmployeeConstance.ID);
		int empId = 0;
		int status = 0;

		if (id != null && !id.equals(EmployeeConstance.BLANK)) {
			empId = Integer.parseInt(id);
		}

		String firstName = request.getParameter(EmployeeConstance.FIRST_NAME);
		String lastName = request.getParameter(EmployeeConstance.LAST_NAME);
		String email = request.getParameter(EmployeeConstance.EMAIL);
		String contact = request.getParameter(EmployeeConstance.CONTACT);
		String gender = request.getParameter(EmployeeConstance.GENDER);
		String course = request.getParameter(EmployeeConstance.COURSE);

		Employee employee = new Employee();
		employee.setId(empId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setContact(contact);
		employee.setGender(gender);
		employee.setCourse(course);
		
		if (empId != 0) {
			status = EmployeeDao.update(employee);
			out.print("<p>Record Update successfully!!</p>");
			
		} else {
			status = EmployeeDao.save(employee);
			out.print("<p>Record saved successfully!!</p>");
		}

		if (status > 0) {
			request.getRequestDispatcher("Index.jsp").include(request, response);
		} 

		out.close();

	}

}
