package com.employee.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.employee.dao.DeleteEmployeeDAO;


@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
		 try {
	          int empId = Integer.parseInt(req.getParameter("empId"));
	          System.out.println("===================================");
	          System.out.println(empId);
	          System.out.println("===================================");

	          boolean isDeleted = new DeleteEmployeeDAO().deleteEmployee(empId);

	          if (isDeleted) {
	        	  req.setAttribute("message", "Employee deleted successfully!");
	        	 req.getRequestDispatcher("msg.jsp").forward(req, response);
	          } else {
	        	  req.setAttribute("message", "Employee deleted Fail!");
	         	 req.getRequestDispatcher("msg.jsp").forward(req, response);
	          }

	    } catch (NumberFormatException e) {
	    	req.setAttribute("message", "Invalid employee ID!");
	    	req.setAttribute("messageType", "error");
	    } catch (Exception e) {
	    	req.setAttribute("message", "Error: " + e.getMessage());
	    	req.setAttribute("messageType", "error");
	    }

	}

	
}

