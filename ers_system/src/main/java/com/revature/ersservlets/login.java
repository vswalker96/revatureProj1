package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.Dashboard;
import com.revature.daoimplementations.UserDaoImpl;;;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDaoImpl user = new UserDaoImpl();

		user.login(username, password);

		if (user != null) {
			
			HttpSession session = request.getSession();
			int userId = user.myUser.getUserId();
			int roleId = user.myUser.getRoleId();
			session.setAttribute("item1", userId);
			session.setAttribute("item2", roleId);
			
			if(roleId == 1) {
				out.print("<h3>Welcome </h3>" + user.myUser.getFirstName());
				Dashboard.logger.trace("Employee "+ username + " has logged in." );
				RequestDispatcher rd = request.getRequestDispatcher("employeeHomepage.jsp");
				rd.forward(request, response);
			}else {
				out.print("<h3>Welcome </h3>" + user.myUser.getFirstName());
				Dashboard.logger.trace("Manager "+ username + " has logged in." );
				RequestDispatcher rd = request.getRequestDispatcher("managerHomepage.jsp");
				rd.forward(request, response);
				
				
			}
			
			
			
		}
		
		
		
		

	}
}
