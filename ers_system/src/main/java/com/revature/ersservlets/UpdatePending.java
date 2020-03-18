package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.FinanceManagerDaoImpl;
import com.revature.daoimplementations.ReimbursementDaoImpl;
import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.models.User;

/**
 * Servlet implementation class UpdatePending
 */
public class UpdatePending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePending() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int requestId = Integer.parseInt(request.getParameter("requestId"));
		int status = Integer.parseInt(request.getParameter("statusId"));
		int userId = (Integer) session.getAttribute("item1");
		FinanceManagerDaoImpl fm = new FinanceManagerDaoImpl();
		User user = new User();
		
		user.setUserId(userId);
		
		fm.updatePending(user, requestId, status);
		
		out.print("Welcome");
		
		RequestDispatcher rd = request.getRequestDispatcher("managerHomepage.jsp");
		rd.forward(request, response);
	}

}
