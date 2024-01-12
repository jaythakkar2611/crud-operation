package com.ignek.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ignek.crud.dao.EmployeeDao;
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
		String editId = request.getParameter("editId");
		String deleteId = request.getParameter("deleteId");

		if (editId != null) {
			Employee employee = EmployeeDao.getEmpById(Integer.parseInt(editId));
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		
		if(deleteId != null)
		{
			EmployeeDao.delete(Integer.parseInt(deleteId));
			response.sendRedirect("ViewServlet");
		}

	}

}
