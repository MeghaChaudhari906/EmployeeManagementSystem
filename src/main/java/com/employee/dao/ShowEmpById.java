package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;


public class ShowEmpById {

	public static final String SHOWEMPBYID = "select * from employees where EMP_ID=?";
	public static final String SHOWEMPBYNAME = "select * from employees where EMP_NAME=?";
	List<Employee> list= new ArrayList<Employee>();
	Employee e=null;
	public List<Employee> getEmpById(int id) {
	try {
		
		Connection con=DatabaseConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(SHOWEMPBYID);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			e=new Employee();
			e.setEmpId(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setPhone(rs.getString(4));
			e.setDepartment(rs.getString(5));
			e.setSalary(rs.getDouble(6));
			e.setJoinDate(rs.getDate(7));
			e.setCreatedDate(rs.getDate(8));
			list.add(e);
		}
		
		
	}catch(Exception ee) {
		ee.printStackTrace();
	}
	return list;
	}
	
	
	public List<Employee> getEmpByName(String name) {
		try {
			
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SHOWEMPBYNAME);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				e=new Employee();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhone(rs.getString(4));
				e.setDepartment(rs.getString(5));
				e.setSalary(rs.getDouble(6));
				e.setJoinDate(rs.getDate(7));
				e.setCreatedDate(rs.getDate(8));
				list.add(e);
			}
			
			
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return list;
		}
		
}
