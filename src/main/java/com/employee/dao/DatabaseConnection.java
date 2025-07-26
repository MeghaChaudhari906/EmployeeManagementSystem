package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	  // Database configuration - Update these values according to your Oracle setup
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DB_USERNAME = "c##meta"; // Change to your Oracle username
    private static final String DB_PASSWORD = "Nareshit"; // Change to your Oracle password
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * Get database connection
     * 
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
          Connection connection = null;

          try {
                // Load Oracle JDBC driver
                Class.forName(DB_DRIVER);

                // Establish connection
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                System.out.println("Database connected successfully!");

          } catch (ClassNotFoundException e) {
                System.err.println("Oracle JDBC Driver not found!");
                e.printStackTrace();
                throw new SQLException("Driver not found", e);
          } catch (SQLException e) {
                System.err.println("Database connection failed!");
                e.printStackTrace();
                throw e;
          }

          return connection;
    }

    /**
     * Close database connection
     * 
     * @param connection Connection to close
     */
    public static void closeConnection(Connection connection) {
          if (connection != null) {
                try {
                      connection.close();
                      System.out.println("Database connection closed successfully!");
                } catch (SQLException e) {
                      System.err.println("Failed to close database connection!");
                      e.printStackTrace();
                }
          }
    }

    /**
     * Test database connection
     * 
     * @return true if connection successful, false otherwise
     */
    public static boolean testConnection() {
          try {
                Connection conn = getConnection();
                closeConnection(conn);
                return true;
          } catch (SQLException e) {
                System.err.println("Database connection test failed!");
                return false;
          }
    }
}


