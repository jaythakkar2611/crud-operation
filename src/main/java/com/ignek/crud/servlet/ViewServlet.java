package com.ignek.crud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.constance.EmployeeConstance;
import com.ignek.crud.dao.EmployeeService;
import com.ignek.crud.dto.Employee;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<Employee> list = EmployeeService.getAllEmployee();
		request.setAttribute(EmployeeConstance.LIST, list);
		request.getRequestDispatcher("ViewPage.jsp").forward(request, response);
	}

}
