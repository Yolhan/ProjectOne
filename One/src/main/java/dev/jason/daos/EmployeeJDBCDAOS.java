package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jason.entities.Employee;
import dev.jason.utilities.ConnectionUtil;

public class EmployeeJDBCDAOS implements EmployeeDAOS {

	public Employee getEmployeebyID(int e_id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM employee WHERE e_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Employee employee = new Employee();
			employee.setE_id(rs.getInt("e_id"));
			employee.setPassword(rs.getString("password"));
			employee.setUsername(rs.getString("username"));
			employee.setIsmanager(rs.getBoolean("is_manager"));
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("That e_id was not found.");
		return null;
	}

	public List<Employee> getEmployees() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Employee emp;
			while (rs.next()) {
				emp = new Employee();
				emp.setE_id(rs.getInt("e_id"));
				emp.setPassword(rs.getString("password"));
				emp.setUsername(rs.getString("username"));
				emp.setIsmanager(rs.getBoolean("is_manager"));
				employees.add(emp);
			}
			if(employees.size() == 0) return null;
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("There was an issue getting the employees.");
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE employee SET username=?, password=?, is_manager=? WHERE e_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setBoolean(3, employee.isIsmanager());
			ps.setInt(4, employee.getE_id());
			ps.execute();
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("That e_id was not found.");
		return null;
	}

}
