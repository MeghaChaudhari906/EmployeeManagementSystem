package com.employee.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.employee.model.Employee;

/**
 * Employee Data Access Object (DAO) Class
 * Handles all database operations for Employee entity
 */
public class EmployeeDAO {

      /**
       * Add a new employee to the database
       * 
       * @param employee Employee object to add
       * @return true if successful, false otherwise
       */
      public boolean addEmployee(Employee employee) {
            boolean isAdded = false;
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                  conn = DatabaseConnection.getConnection();

                  String sql = "INSERT INTO employees (emp_id, emp_name, email, phone, department, salary, join_date) "
                              +
                              "VALUES (emp_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";

                  pstmt = conn.prepareStatement(sql);
                  pstmt.setString(1, employee.getEmpName());
                  pstmt.setString(2, employee.getEmail());
                  pstmt.setString(3, employee.getPhone());
                  pstmt.setString(4, employee.getDepartment());
                  pstmt.setDouble(5, employee.getSalary());

                  int result = pstmt.executeUpdate();
                  if (result > 0) {
                        isAdded = true;
                        System.out.println("Employee added successfully!");
                  }

            } catch (SQLException e) {
                  System.err.println("Error adding employee: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  try {
                        if (pstmt != null)
                              pstmt.close();
                        if (conn != null)
                              DatabaseConnection.closeConnection(conn);
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }

            return isAdded;
      }

      /**
       * Get all employees from database
       * 
       * @return List of all employees
       */
      public List<Employee> getAllEmployees() {
            List<Employee> employees = new ArrayList<>();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                  conn = DatabaseConnection.getConnection();

                  String sql = "SELECT * FROM employees ORDER BY emp_id";
                  stmt = conn.createStatement();
                  rs = stmt.executeQuery(sql);

                  while (rs.next()) {
                        Employee employee = new Employee();
                        employee.setEmpId(rs.getInt(1));
                        employee.setEmpName(rs.getString(2));
                        employee.setEmail(rs.getString(3));
                        employee.setPhone(rs.getString(4));
                        employee.setDepartment(rs.getString(5));
                        employee.setSalary(rs.getDouble(6));
                        employee.setJoinDate(rs.getDate(7));
                        employee.setCreatedDate(rs.getDate(8));

                        employees.add(employee);
                  }

            } catch (SQLException e) {
                  System.err.println("Error retrieving employees: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  try {
                        if (rs != null)
                              rs.close();
                        if (stmt != null)
                              stmt.close();
                        if (conn != null)
                              DatabaseConnection.closeConnection(conn);
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }

            return employees;
      }

      /**
       * Get employee by ID
       * 
       * @param empId Employee ID
       * @return Employee object or null if not found
       */
      public Employee getEmployeeById(int empId) {
            Employee employee = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                  conn = DatabaseConnection.getConnection();

                  String sql = "SELECT * FROM employees WHERE emp_id = ?";
                  pstmt = conn.prepareStatement(sql);
                  pstmt.setInt(1, empId);
                  rs = pstmt.executeQuery();

                  if (rs.next()) {
                        employee = new Employee();
                        employee.setEmpId(rs.getInt("emp_id"));
                        employee.setEmpName(rs.getString("emp_name"));
                        employee.setEmail(rs.getString("email"));
                        employee.setPhone(rs.getString("phone"));
                        employee.setDepartment(rs.getString("department"));
                        employee.setSalary(rs.getDouble("salary"));
                        employee.setJoinDate(rs.getDate("join_date"));
                        employee.setCreatedDate(rs.getDate("created_date"));
                        
                  }

            } catch (SQLException e) {
                  System.err.println("Error retrieving employee: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  try {
                        if (rs != null)
                              rs.close();
                        if (pstmt != null)
                              pstmt.close();
                        if (conn != null)
                              DatabaseConnection.closeConnection(conn);
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }

            return employee;
      }

      /**
       * Update employee information
       * 
       * @param employee Employee object with updated information
       * @return true if successful, false otherwise
       */
      public boolean updateEmployee(Employee employee) {
            boolean isUpdated = false;
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                  conn = DatabaseConnection.getConnection();

                  String sql = "UPDATE employees SET emp_name = ?, email = ?, phone = ?, " +
                              "department = ?, salary = ? WHERE emp_id = ?";

                  pstmt = conn.prepareStatement(sql);
                  pstmt.setString(1, employee.getEmpName());
                  pstmt.setString(2, employee.getEmail());
                  pstmt.setString(3, employee.getPhone());
                  pstmt.setString(4, employee.getDepartment());
                  pstmt.setDouble(5, employee.getSalary());
                  pstmt.setInt(6, employee.getEmpId());

                  int result = pstmt.executeUpdate();
                  if (result > 0) {
                        isUpdated = true;
                        System.out.println("Employee updated successfully!");
                  }

            } catch (SQLException e) {
                  System.err.println("Error updating employee: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  try {
                        if (pstmt != null)
                              pstmt.close();
                        if (conn != null)
                              DatabaseConnection.closeConnection(conn);
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }

            return isUpdated;
      }

      /**
       * Delete employee by ID
       * 
       * @param empId Employee ID to delete
       * @return true if successful, false otherwise
       */
     

      /**
       * Search employees by name or department
       * 
       * @param searchTerm Search term
       * @return List of matching employees
       */
      public List<Employee> searchEmployees(String searchTerm) {
            List<Employee> employees = new ArrayList<>();
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                  conn = DatabaseConnection.getConnection();

                  String sql = "SELECT * FROM employees WHERE LOWER(emp_name) LIKE LOWER(?) " +
                              "OR LOWER(department) LIKE LOWER(?) ORDER BY emp_id";

                  pstmt = conn.prepareStatement(sql);
                  String searchPattern = "%" + searchTerm + "%";
                  pstmt.setString(1, searchPattern);
                  pstmt.setString(2, searchPattern);
                  rs = pstmt.executeQuery();

                  while (rs.next()) {
                        Employee employee = new Employee();
                        employee.setEmpId(rs.getInt("emp_id"));
                        employee.setEmpName(rs.getString("emp_name"));
                        employee.setEmail(rs.getString("email"));
                        employee.setPhone(rs.getString("phone"));
                        employee.setDepartment(rs.getString("department"));
                        employee.setSalary(rs.getDouble("salary"));
                        employee.setJoinDate(rs.getDate("join_date"));
                        employee.setCreatedDate(rs.getDate("created_date"));

                        employees.add(employee);
                  }

            } catch (SQLException e) {
                  System.err.println("Error searching employees: " + e.getMessage());
                  e.printStackTrace();
            } finally {
                  try {
                        if (rs != null)
                              rs.close();
                        if (pstmt != null)
                              pstmt.close();
                        if (conn != null)
                              DatabaseConnection.closeConnection(conn);
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }

            return employees;
      }
}