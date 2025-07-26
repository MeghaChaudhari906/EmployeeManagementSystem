<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.employee.model.Employee" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 70%;
            margin: auto;
        }
        th, td {
            border: 1px solid #333;
            padding: 8px;
            text-align: center;
        }
        h2 {
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>

<%
    List<Employee> empList = (List<Employee>) request.getAttribute("list");
    String msg = (String) request.getAttribute("msg");
%>

<% if (empList != null && !empList.isEmpty()) { %>
    <h2>Employee Details</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
            <th>Salary</th>
            <th>JoinDate</th>
            <th>CreatedDate</th>
            <!-- Add more columns as per your Employee class -->
        </tr>
        <% for (Employee emp : empList) { %>
            <tr>
                <td><%= emp.getEmpId() %></td>
                <td><%= emp.getEmpName() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getPhone() %></td>
                <td><%= emp.getDepartment() %></td>
                <td><%= emp.getSalary() %></td>
                <td><%= emp.getJoinDate()%></td>
                <td><%= emp.getCreatedDate() %></td>
                
                <!-- Add more fields if needed -->
            </tr>
        <% } %>
    </table>
<% } else { %>
    <h2><%= msg != null ? msg : "No Data Found" %></h2>
<% } %>

</body>
</html>
