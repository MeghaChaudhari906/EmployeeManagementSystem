<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <!-- Assuming you have a service layer -->
<%
    int empId = (Integer) request.getAttribute("id");

   
    if (empId < 0) {
        out.println("<h3>Employee not found!</h3>");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Employee</title>
</head>
<body>

<h2>Edit Employee Details</h2>

<form action="updateEmployee" method="post">
    <input type="hidden" name="empId" value="<%= empId %>" />
    
    <label for="empName">Name:</label><br/>
    <input type="text" id="empName" name="empName" value=" " required /><br/><br/>
    
    <label for="email">Email:</label><br/>
    <input type="email" id="email" name="email" value=" " required /><br/><br/>
    
    <label for="phone">Phone:</label><br/>
    <input type="text" id="phone" name="phone" value=" " /><br/><br/>
    
    <label for="department">Department:</label><br/>
    <input type="text" id="department" name="department" value=" " /><br/><br/>
    
    <label for="salary">Salary:</label><br/>
    <input type="number" id="salary" name="salary" value=" " /><br/><br/>
    
    <label for="joinDate">Join Date:</label><br/>
    <input type="date" id="joinDate" name="joinDate" value=" " /><br/><br/>
    
    <!-- Add more fields as needed -->
    
    <input type="submit" value="Update Employee" />
</form>

</body>
</html>
