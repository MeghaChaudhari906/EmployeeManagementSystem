<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ page import="java.util.List" %>
<%@ page import="com.employee.model.Employee" %>
<%@ page import="java.text.SimpleDateFormat" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    List<Employee> empList = (List<Employee>) request.getAttribute("employees");
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
            <th>Actions</th>
        </tr>
        <% for (Employee emp : empList) { %>
            <tr>
                <td><%= emp.getEmpId() %></td>
                <td><%= emp.getEmpName() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getPhone() %></td>
                <td><%= emp.getDepartment() %></td>
                <td><%= emp.getSalary() %></td>
                <td><%= emp.getJoinDate() %></td>
                <td><%= emp.getCreatedDate() %></td>
                <td>
                    <!-- Edit Button -->
                    <form action="editEmployee" method="get" style="display:inline;">
                        <input type="hidden" name="empId" value="<%= emp.getEmpId() %>"/>
                        <input type="submit" value="Edit"/>
                    </form>

                    <!-- Delete Button -->
                    <form action="deleteEmployee" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this employee?');">
                        <input type="hidden" name="empId" value="<%= emp.getEmpId() %>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        <% } %>
    </table>
<% } else { %>
    <h2><%= msg != null ? msg : "No Data Found" %></h2>
<% } %>

</body>
</html>