package com.employee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

@WebServlet("/showAllEmp")
public class ShowAllEmpServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		 List<Employee> employees = new EmployeeDAO().getAllEmployees();
	        request.setAttribute("employees", employees);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("view-employees.jsp");
	        dispatcher.forward(request, response);

       
  }

}


