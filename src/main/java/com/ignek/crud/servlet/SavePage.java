package com.ignek.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.ignek.crud.constance.EmployeeConstance;
import com.ignek.crud.dao.EmployeeDao;
import com.ignek.crud.dto.Employee;

@WebServlet("/SavePage")
public class SavePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter(EmployeeConstance.ID);
		int empId = EmployeeConstance.DEFAULT_INTEGER;
		int status = EmployeeConstance.DEFAULT_INTEGER;

		if (id != null && !id.equals(EmployeeConstance.BLANK)) {
			empId = Integer.parseInt(id);
		}
		String firstName = request.getParameter(EmployeeConstance.FIRST_NAME);
		String lastName = request.getParameter(EmployeeConstance.LAST_NAME);
		String email = request.getParameter(EmployeeConstance.EMAIL);
		String contact = request.getParameter(EmployeeConstance.CONTACT);
		String gender = request.getParameter(EmployeeConstance.GENDER);
		String course = request.getParameter(EmployeeConstance.COURSE);

		Employee employee = new Employee(empId, firstName, lastName, email, contact, gender, course);

		if (empId != EmployeeConstance.DEFAULT_INTEGER) {
			status = EmployeeDao.update(employee);
			//
			JOptionPane.showMessageDialog(null,"Record Updated successfully!!" );
			
		} else {
			status = EmployeeDao.save(employee);
			JOptionPane.showMessageDialog(null, "Record saved successfully!!");
		}

		if (status > EmployeeConstance.DEFAULT_INTEGER) {
			request.getRequestDispatcher("Index.jsp").include(request, response);
		}
		out.close();
	}
}
