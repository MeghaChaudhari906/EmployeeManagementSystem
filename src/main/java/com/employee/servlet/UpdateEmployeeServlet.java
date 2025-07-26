package com.employee.servlet;



import java.io.IOException;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import com.employee.dao.UpdateEmployeeDAO;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            int empId = Integer.parseInt(req.getParameter("empId"));
            String empName = req.getParameter("empName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String department = req.getParameter("department");
            double salary = Double.parseDouble(req.getParameter("salary"));
            Date jod = Date.valueOf(req.getParameter("joinDate"));



            boolean isUpdated = new UpdateEmployeeDAO().updateEmployee(empId, empName, email, phone,department,salary,jod);

            if (isUpdated) {
                req.setAttribute("message", "Employee updated successfully!");
                req.getRequestDispatcher("msg.jsp").forward(req, res);
            } else {
                req.setAttribute("message", "Employee update failed!");
                req.getRequestDispatcher("msg.jsp").forward(req, res);

            }

        } catch (NumberFormatException e) {
            req.setAttribute("message", "Invalid employee ID!");
            req.getRequestDispatcher("msg.jsp").forward(req, res);
        } catch (Exception e) {
            req.setAttribute("message", "Error: " + e.getMessage());
            req.getRequestDispatcher("msg.jsp").forward(req, res);
        }
    }
}
