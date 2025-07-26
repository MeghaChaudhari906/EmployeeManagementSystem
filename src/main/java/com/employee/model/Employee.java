package com.employee.model;


	import java.sql.Date;

	/**
	 * Employee Model Class
	 * Represents an employee entity with all necessary attributes
	 */
	public class Employee {
	      private int empId;
	      private String empName;
	      private String email;
	      private String phone;
	      private String department;
	      private double salary;
	      private Date joinDate;
	      private Date createdDate;

	      // Default constructor
	      public Employee() {
	      }

	      // Constructor without ID (for new employee creation)
	      public Employee(String empName, String email, String phone, String department, double salary) {
	            this.empName = empName;
	            this.email = email;
	            this.phone = phone;
	            this.department = department;
	            this.salary = salary;
	      }

	      // Constructor with all fields
	      public Employee(int empId, String empName, String email, String phone,
	                  String department, double salary, Date joinDate, Date createdDate) {
	            this.empId = empId;
	            this.empName = empName;
	            this.email = email;
	            this.phone = phone;
	            this.department = department;
	            this.salary = salary;
	            this.joinDate = joinDate;
	            this.createdDate = createdDate;
	      }

	      // Getters and Setters
	      public int getEmpId() {
	            return empId;
	      }

	      public void setEmpId(int empId) {
	            this.empId = empId;
	      }

	      public String getEmpName() {
	            return empName;
	      }

	      public void setEmpName(String empName) {
	            this.empName = empName;
	      }

	      public String getEmail() {
	            return email;
	      }

	      public void setEmail(String email) {
	            this.email = email;
	      }

	      public String getPhone() {
	            return phone;
	      }

	      public void setPhone(String phone) {
	            this.phone = phone;
	      }

	      public String getDepartment() {
	            return department;
	      }

	      public void setDepartment(String department) {
	            this.department = department;
	      }

	      public double getSalary() {
	            return salary;
	      }

	      public void setSalary(double salary) {
	            this.salary = salary;
	      }

	      public Date getJoinDate() {
	            return joinDate;
	      }

	      public void setJoinDate(Date joinDate) {
	            this.joinDate = joinDate;
	      }

	      public Date getCreatedDate() {
	            return createdDate;
	      }

	      public void setCreatedDate(Date createdDate) {
	            this.createdDate = createdDate;
	      }

	      @Override
	      public String toString() {
	            return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email +
	                        ", phone=" + phone + ", department=" + department + ", salary=" + salary +
	                        ", joinDate=" + joinDate + "]";
	      }
	}


