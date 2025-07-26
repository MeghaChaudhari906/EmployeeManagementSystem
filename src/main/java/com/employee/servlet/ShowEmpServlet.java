package com.employee.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.employee.dao.ShowEmpById;
import com.employee.model.Employee;

@WebServlet("/showEmp")
public class ShowEmpServlet extends GenericServlet{

	String name;
	Integer id=-1; // for if else
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("eid"));
		String name = req.getParameter("name");
		//name=req.getParameter("name");
		if(id>0) {
		List<Employee> list= new ShowEmpById().getEmpById(id);
		if(list!=null) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("showEmployee.jsp").forward(req, res);
			
		}else {
			req.setAttribute("msg", "NO Employee");
			req.getRequestDispatcher("showEmployee.jsp").forward(req, res);
		}
		
	} else {
		List<Employee> list= new ShowEmpById().getEmpByName(name);
		if(list!=null) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("showEmployee.jsp").forward(req, res);
			
		}
		else {
			req.setAttribute("msg", "NO Employee");
			req.getRequestDispatcher("showEmployee.jsp").forward(req, res);
		}
	}
		
		
		
	}

	
}
