package com.revature.ersservlets;

import com.revature.rest.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.ReimbursementDaoImpl;
import com.revature.project1.models.Reimburserment;
import com.revature.project1.models.User;

/**
 * Servlet implementation class ViewResolved
 */
public class ViewResolved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResolved() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("item1");
		int roleId = (Integer) session.getAttribute("item2");
		ReimbursementDaoImpl reim = new ReimbursementDaoImpl();
		Reimburserment reimbursement = new Reimburserment();
		User user = new User();
		user.setRoleId(roleId);
		user.setUserId(userId);
		
		if (roleId==1) {
			
			ArrayList<Reimburserment> resolved= reim.viewMyResolved(userId);
			session.setAttribute("resolved", resolved);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("resolved.jsp");
			rd.include(request, response);
			
			
		}else {
			ArrayList<Reimburserment> resolved = reim.viewAllResolved();
			session.setAttribute("resolved", resolved);
			RequestDispatcher rd = request.getRequestDispatcher("resolved.jsp");
			rd.include(request, response);
			//out.println(reim.viewAllResolved());
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
