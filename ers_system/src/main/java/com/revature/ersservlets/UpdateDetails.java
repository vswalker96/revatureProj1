package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.EmployeeDaoImpl;
import com.revature.daoimplementations.UserDaoImpl;
import com.revature.project1.models.User;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int userId = (Integer) session.getAttribute("item1");
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		User userdetails = new User();
		
		userdetails.setFirstName(fname);
		userdetails.setLastName(lname);
		userdetails.setEmail(email);
		userdetails.setUserId(userId);
		
		
		emp.updateUser(userdetails);
		

		
		out.print("User Details Updated ");
		
		RequestDispatcher rd = request.getRequestDispatcher("employeeHomepage.jsp");
		rd.include(request, response);
	}

}
