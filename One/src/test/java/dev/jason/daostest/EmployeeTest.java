package dev.jason.daostest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dev.jason.daos.CourseDAOS;
import dev.jason.daos.EmployeeDAOS;
import dev.jason.daos.EmployeeJDBCDAOS;
import dev.jason.entities.Course;
import dev.jason.entities.Employee;
import junit.framework.Assert;

public class EmployeeTest {

	@Test
	public void getemployeebyIDTest() {
		EmployeeDAOS ed = new EmployeeJDBCDAOS();
		Employee employee = new Employee();
		
		// Positive test case
		employee.setE_id(3);
		employee = ed.getEmployeebyID(employee.getE_id());
		Assert.assertEquals("Mike", employee.getUsername());
		System.out.println(employee);
		
		// Negative test case
		employee.setE_id(6);
		employee = ed.getEmployeebyID(employee.getE_id());
		Assert.assertNull(employee);
		System.out.println(employee);
	}

	@Test
	public void getEmployeesTest() {
		EmployeeDAOS ed = new EmployeeJDBCDAOS();
		
		List<Employee> employees = new ArrayList<Employee>(ed.getEmployees());
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void updateEmployeeTest() {
		EmployeeDAOS ed = new EmployeeJDBCDAOS();
		Employee employee = new Employee(6, "Phylicia the Great", "I_Rock", true);
		
		employee = ed.updateEmployee(employee);
		Assert.assertNotNull(employee);
		System.out.println(employee);

		employee.setE_id(22);
		ed.updateEmployee(employee);
		Assert.assertNull(employee);
		
	}
	
}
