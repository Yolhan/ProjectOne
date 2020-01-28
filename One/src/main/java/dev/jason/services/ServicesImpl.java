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

	public Employee login(Employee employee) {
		EmployeeDAOS ed = new EmployeeJDBCDAOS();
		List<Employee> employees = new ArrayList<Employee>(ed.getEmployees());
		for (Employee employee2 : employees) {
			if(employee2.getUsername() == employee.getUsername() && employee2.getPassword() == employee.getPassword()) {
				// Username and password accepted
				return employee2;
			}
		}
		// There was no employee with that username or password
		return null;
		
	}

	public boolean logout(Employee employee) {
		// Not sure what to do here yet
		return false;
		
	}

	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
		ReimbursementDAOS rd = new ReimbursementJDBCDAOS();
		reimbursement = rd.createReimbursement(reimbursement);
		return reimbursement;
	}

	public void showReimbursements(List<Reimbursement> reimbursements) {
		// Have to wait on this one
		
	}

	public void approveReimbursement(Reimbursement reimbursement) {
		ReimbursementDAOS rd = new ReimbursementJDBCDAOS();
		reimbursement.setStatus(2); // Approved
		rd.updateReimbursement(reimbursement);
		
	}

	public void denyReimbursement(Reimbursement reimbursement) {
		ReimbursementDAOS rd = new ReimbursementJDBCDAOS();
		reimbursement.setStatus(3); // Denied
		rd.updateReimbursement(reimbursement);
		
	}

	public void sortReimbursement() {
		// TODO Auto-generated method stub
		
	}

}
