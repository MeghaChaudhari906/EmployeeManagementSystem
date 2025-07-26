package com.employee.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeDAO {

    public boolean updateEmployee(int empId, String empName, String email, String phone,String department, double salary,Date jod) {
        boolean isUpdated = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "UPDATE employees SET emp_name = ?, email = ?, phone = ? ,department=?, salary=?, JOIN_DATE=? WHERE emp_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empName);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, department);
            pstmt.setDouble(5, salary);
            pstmt.setDate(6, jod);
            pstmt.setInt(7, empId);

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
                if (pstmt != null) pstmt.close();
                if (conn != null) DatabaseConnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
    }
    
    }

