package com.ignek.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.constance.EmployeeConstance;
import com.ignek.crud.dao.EmployeeService;
import com.ignek.crud.dto.Employee;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String editId = request.getParameter(EmployeeConstance.EDIT_ID);
		String deleteId = request.getParameter(EmployeeConstance.DELETE_ID);

		if (editId != null) {
			Employee employee = EmployeeService.getEmpById(Integer.parseInt(editId));
			request.setAttribute(EmployeeConstance.EMPLOYEE, employee);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}

		if (deleteId != null) {
			EmployeeService.delete(Integer.parseInt(deleteId));
			response.sendRedirect("ViewServlet");
		}

	}

}
