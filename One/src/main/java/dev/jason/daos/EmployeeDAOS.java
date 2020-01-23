package dev.jason.daos;

import java.util.List;

import dev.jason.entities.Employee;

public interface EmployeeDAOS {
//CRUD
	
	// There is no CREATE for Employees
	
	// READ
	
	/***
	 * Will get the item by id.
	 * @param e_id - the primary key to find on the database to be found
	 * @return - the item was found. Will return NULL if the item was not found.
	 */
	public Employee getEmployeebyID(int e_id);
	
	/***
	 * Will ge tall the items from the database.
	 * @return A list of all items from the database. Will return NULL if the database is empty
	 */
	public List<Employee> getEmployees();
	
	// UPDATE
	/***
	 * The update updates via E_ID
	 * @param employee - The employee to be updated by id with the fields to be updated
	 * @return - the fully updated employee. Will return NULL if the employee was not found by e_id
	 */
	public Employee updateEmployee(Employee employee);
}
