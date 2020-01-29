package dev.jason.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.jason.entities.Employee;
import dev.jason.services.Services;
import dev.jason.services.ServicesImpl;
import com.google.gson.Gson;

public class EmployeeController {
	private Services service = new ServicesImpl();
	
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		// Get username and password
		String username = request.getParameter("username");	
		String password = request.getParameter("password");
		List<Employee> employees = service.getEmployees();
		
		// Compare username and password
		Employee result = new Employee();
		boolean found = false;
		for (Employee employee : employees) {
			if(username == employee.getUsername() && password == employee.getPassword()) {
				result = employee;
				found = true;
				break;
			}
		}
		
		if(!found) {
			// TODO:: The username and password is incorrect
			return;
		}
		
		// TODO:: Return the json of the found user
		
		
		
		/*Set<Player> players = ps.getAllPlayers();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(players);
		
		PrintWriter pw = response.getWriter();
		
		pw.append(json);
		*/
	}
}
