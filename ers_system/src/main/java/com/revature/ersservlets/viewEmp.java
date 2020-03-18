package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.FinanceManagerDaoImpl;
import com.revature.daoimplementations.UserDaoImpl;
import com.revature.project1.models.User;

/**
 * Servlet implementation class viewEmp
 */
public class viewEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		FinanceManagerDaoImpl fm = new FinanceManagerDaoImpl();
		UserDaoImpl user = new UserDaoImpl();
		int userId = (Integer) session.getAttribute("item1");
		int roleId = (Integer) session.getAttribute("item2");
		
//		User user = new User();
		
		if(roleId == 1) {
			User myList = user.viewUser(userId);
			//System.out.println(user.viewUser(userId));
		//out.print(user.viewUser(userId));	
			session.setAttribute("myEmps", myList);
			RequestDispatcher rd = request.getRequestDispatcher("myUser.jsp");
			rd.include(request, response);
			
		}else {
			ArrayList<User> myList=fm.getUsers();	
			
			session.setAttribute("myEmps", myList);
			RequestDispatcher rd = request.getRequestDispatcher("Users.jsp");
			rd.include(request, response);
		}
		
		
		
		//out.print(fm.getUsers().toString());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
