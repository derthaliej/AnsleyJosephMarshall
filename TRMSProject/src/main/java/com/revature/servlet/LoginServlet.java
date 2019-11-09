package com.revature.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.Employee;
import com.revature.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserService US = new UserService();
 /**
  * @see HttpServlet#HttpServlet()
  */
 public LoginServlet() {
     super();
     // TODO Auto-generated constructor stub
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null){
			response.sendRedirect("home");
		}else {
			response.sendRedirect("LoginPage.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee user = US.autheticateUser(username, password);
		HttpSession session;
		if(user!=null) {
			System.out.println("Login Servlet");
			session = request.getSession(true);
			session.setAttribute("name", user.getFirstName());
			session.setAttribute("role", user.getEmpTyp());
			session.setAttribute("id", user.getEmpTyp());
			response.sendRedirect("E.html");// 
			
		}
		else {
			response.sendRedirect("LoginPage.html");
		}
	}

}
