package dev.jason.services;

import java.util.List;

import dev.jason.entities.Employee;
import dev.jason.entities.Reimbursement;

public interface Services {
	public Employee login(Employee employee);
	public boolean logout(Employee employee);
	public Reimbursement submitReimbursement(Reimbursement reimbursement);
	public void showReimbursements(List<Reimbursement> reimbursements);
	public void approveReimbursement(Reimbursement reimbursement);
	public void denyReimbursement(Reimbursement reimbursement);
	public void sortReimbursement();
}
