package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.UserDaoImpl;
import com.revature.daoimplementations.ReimbursementDaoImpl;


/**
 * Servlet implementation class createRequest
 */
public class createRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("item1");
		String description = request.getParameter("description");
		String receipt = request.getParameter("receipt");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		ReimbursementDaoImpl reim = new ReimbursementDaoImpl();
		reim.createRequest(userId, description, receipt, typeId, amount);
		
		out.println("<h4> Request Submitted</h4>" );
		
		RequestDispatcher rd = request.getRequestDispatcher("employeeHomepage.jsp");
		rd.include(request, response);

		out.close();
	}

}
