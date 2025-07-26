package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeDAO {

	 public boolean deleteEmployee(int empId) {
         boolean isDeleted = false;
         Connection conn = null;
         PreparedStatement pstmt = null;

         try {
               conn = DatabaseConnection.getConnection();

               String sql = "DELETE FROM employees WHERE emp_id = ?";
               pstmt = conn.prepareStatement(sql);
               pstmt.setInt(1, empId);

               int result = pstmt.executeUpdate();
               if (result > 0) {
                     isDeleted = true;
                     System.out.println("Employee deleted successfully!");
               }

         } catch (SQLException e) {
               System.err.println("Error deleting employee: " + e.getMessage());
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

         return isDeleted;
   }
}
