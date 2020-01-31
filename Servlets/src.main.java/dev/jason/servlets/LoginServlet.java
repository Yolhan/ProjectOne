package dev.jason.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// TODO:: Logic
		
		PrintWriter pw = rep.getWriter();
		// TODO:: Need to make a Gson and json to return result
		pw.print();
	}
}
