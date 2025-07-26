package com.employee.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
@WebServlet("/insertEmployee")
public class AddEmployee extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		 try {
             // Get form parameters
             String name = request.getParameter("empName");
             String email = request.getParameter("email");
             String phone = request.getParameter("phone");
             String department = request.getParameter("department");
             double salary = Double.parseDouble(request.getParameter("salary"));

             // Create employee object
             Employee employee = new Employee(name, email, phone, department, salary);

             // Add employee to database
             boolean isAdded = new EmployeeDAO().addEmployee(employee);

             if (isAdded) {
                   request.setAttribute("message", "Employee added successfully!");
                   request.getRequestDispatcher("msg.jsp").forward(request, response);
             } else {
                   request.setAttribute("message", "Failed to add employee!");
                   request.getRequestDispatcher("msg.jsp").forward(request, response);
             }

       } catch (NumberFormatException e) {
             request.setAttribute("message", "Invalid salary format!");
             request.setAttribute("messageType", "error");
       } catch (Exception e) {
             request.setAttribute("message", "Error: " + e.getMessage());
             request.setAttribute("messageType", "error");
       }

       // Redirect to employee list
       
		
	}

      
 }

