<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.employee.model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Employee - Employee Management System</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <div class="container">
        <!-- Header -->
        <header class="header">
            <h1>Edit Employee</h1>
            <p>Update employee information</p>
        </header>

        <!-- Navigation -->
        <nav class="nav">
            <a href="index.html">Home</a>
            <a href="add-employee.html">Add Employee</a>
            <a href="showAllEmp">View All Employees</a>
            <a href="search-employee.html">Search Employee</a>
        </nav>

        <!-- Main Content -->
        <main class="card">
            <%
            Employee employee = (Employee) request.getAttribute("employee");
            if (employee != null) {
            %>
                <h2>Edit Employee: <%= employee.getEmpName() %></h2>
                
                <form action="editEmployee" method="post" id="editEmployeeForm">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                    
                    <div class="form-group">
                        <label for="empName">Full Name *</label>
                        <input type="text" id="empName" name="empName" required 
                               value="<%= employee.getEmpName() %>"
                               placeholder="Enter employee's full name" maxlength="100">
                    </div>
                    
                    <div class="form-group">
                        <label for="email">Email Address *</label>
                        <input type="email" id="email" name="email" required 
                               value="<%= employee.getEmail() %>"
                               placeholder="Enter email address" maxlength="100">
                    </div>
                    
                    <div class="form-group">
                        <label for="phone">Phone Number *</label>
                        <input type="tel" id="phone" name="phone" required 
                               value="<%= employee.getPhone() %>"
                               placeholder="Enter phone number" maxlength="15" pattern="[0-9]{10,15}">
                    </div>
                    
                    <div class="form-group">
                        <label for="department">Department *</label>
                        <select id="department" name="department" required>
                            <option value="">-- Select Department --</option>
                            <option value="IT" <%= "IT".equals(employee.getDepartment()) ? "selected" : "" %>>Information Technology</option>
                            <option value="HR" <%= "HR".equals(employee.getDepartment()) ? "selected" : "" %>>Human Resources</option>
                            <option value="Finance" <%= "Finance".equals(employee.getDepartment()) ? "selected" : "" %>>Finance</option>
                            <option value="Marketing" <%= "Marketing".equals(employee.getDepartment()) ? "selected" : "" %>>Marketing</option>
                            <option value="Operations" <%= "Operations".equals(employee.getDepartment()) ? "selected" : "" %>>Operations</option>
                            <option value="Sales" <%= "Sales".equals(employee.getDepartment()) ? "selected" : "" %>>Sales</option>
                            <option value="Support" <%= "Support".equals(employee.getDepartment()) ? "selected" : "" %>>Customer Support</option>
                            <option value="Admin" <%= "Admin".equals(employee.getDepartment()) ? "selected" : "" %>>Administration</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="salary">Monthly Salary *</label>
                        <input type="number" id="salary" name="salary" required 
                               value="<%= employee.getSalary() %>"
                               placeholder="Enter monthly salary" min="10000" max="1000000" step="0.01">
                    </div>
                    
                    <div class="form-group" style="background: #f8f9fa; padding: 15px; border-radius: 5px;">
                        <h4>Current Employee Details:</h4>
                        <p><strong>Employee ID:</strong> <%= employee.getEmpId() %></p>
                        <p><strong>Join Date:</strong> 
                            <% if (employee.getJoinDate() != null) { %>
                                <%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(employee.getJoinDate()) %>
                            <% } else { %>
                                N/A
                            <% } %>
                        </p>
                    </div>
                    
                    <div style="text-align: center; margin-top: 30px;">
                        <button type="submit" class="btn btn-success">Update Employee</button>
                        <button type="reset" class="btn btn-warning">Reset Changes</button>
                        <a href="showAllEmp" class="btn btn-primary">Cancel</a>
                    </div>
                </form>
                
            <% } else { %>
                <div class="message error">
                    Employee not found! Please go back and try again.
                </div>
                <div style="text-align: center; margin-top: 20px;">
                    <a href="showAllEmp" class="btn btn-primary">Back to Employee List</a>
                </div>
            <% } %>
        </main>

        <!-- Footer -->
        <footer class="footer">
            <p>&copy; 2024 Employee Management System. Built with Java, Servlets, JSP, and Oracle Database.</p>
        </footer>
    </div>

    <script>
        // Form validation
        document.getElementById('editEmployeeForm').addEventListener('submit', function(e) {
            const name = document.getElementById('empName').value.trim();
            const email = document.getElementById('email').value.trim();
            const phone = document.getElementById('phone').value.trim();
            const department = document.getElementById('department').value;
            const salary = document.getElementById('salary').value;
            
            if (!name || !email || !phone || !department || !salary) {
                alert('Please fill in all required fields.');
                e.preventDefault();
                return false;
            }
            
            if (salary < 10000) {
                alert('Salary must be at least ₹10,000.');
                e.preventDefault();
                return false;
            }
            
            // Phone number validation
            const phonePattern = /^[0-9]{10,15}$/;
            if (!phonePattern.test(phone)) {
                alert('Please enter a valid phone number (10-15 digits).');
                e.preventDefault();
                return false;
            }
            
            // Confirm update
            if (!confirm('Are you sure you want to update this employee\'s information?')) {
                e.preventDefault();
                return false;
            }
            
            return true;
        });
        
        // Reset form validation
        document.querySelector('button[type="reset"]').addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to reset all changes?')) {
                e.preventDefault();
                return false;
            }
        });
    </script>
</body>
</html> 