package dev.jason.services;

import java.util.ArrayList;
import java.util.List;

import dev.jason.daos.EmployeeDAOS;
import dev.jason.daos.EmployeeJDBCDAOS;
import dev.jason.daos.ReimbursementDAOS;
import dev.jason.daos.ReimbursementJDBCDAOS;
import dev.jason.entities.Employee;
import dev.jason.entities.Reimbursement;

public class ServicesImpl implements Services {

	public List<Employee> getEmployees() {
		EmployeeDAOS ed = new EmployeeJDBCDAOS();
		List<Employee> employees = new ArrayList<Employee>(ed.getEmployees());
		return employees;
	}



}
