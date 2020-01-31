package dev.jason.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.jason.entities.Employee;
import dev.jason.services.Services;
import dev.jason.services.ServicesImpl;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class EmployeeController {
	private Services service = new ServicesImpl();
	
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		// Get username and password
		Employee emp = new Employee();
		
		String json = request.getParameter("payload");
		Gson gson = new Gson();
		emp = gson.fromJson(json, Employee.class);
	

		System.out.println(emp);
		List<Employee> employees = service.getEmployees();
		
		PrintWriter pw = response.getWriter();
		System.out.println("Entered getLogin() from serverside");
		// Compare username and password
		for (Employee employee : employees) {
			if(emp.getUsername().equals(employee.getUsername()) && emp.getPassword().equals(employee.getPassword())) {
				if(employee.isIsmanager()) {
					System.out.println("Sending to Manager Page from serverside");
					json = "http://localhost:8080/ProjectOne/manager.html";
					pw.append(json);
					return;
				} else {
					System.out.println("Sending to employee from serverside");
					json = "http://localhost:8080/ProjectOne/employee.html";
					pw.append(json);
					return;
				}

			}
		}
		// If the username or password was incorrect
		System.out.println("UN or pass fail from serverside");
		json = "fail";
		pw.append(json);
		

	}
}
