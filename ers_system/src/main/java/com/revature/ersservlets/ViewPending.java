package com.revature.ersservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimplementations.ReimbursementDaoImpl;
import com.revature.daoimplementations.UserDaoImpl;
import com.revature.project1.models.Reimburserment;
import com.revature.project1.models.User;

/**
 * Servlet implementation class ViewPending
 */
public class ViewPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimbursementDaoImpl reim = new ReimbursementDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPending() {
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
		int userId = (Integer) session.getAttribute("item1");
		int roleId = (Integer) session.getAttribute("item2");
		//UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		
		
		User user = new User();
		user.setRoleId(roleId);
		user.setUserId(userId);
		
		
		
		
		if (roleId==1) {
			ArrayList<Reimburserment> pending= reim.viewMyPending(userId);
		
			session.setAttribute("pendingList", pending);
			
			RequestDispatcher rd = request.getRequestDispatcher("ViewAllPending.jsp");
			rd.forward(request, response);
			
			out.println(reim.viewMyPending(userId));
		}else {
			
			ArrayList<Reimburserment> reimbursementPending = reim.viewAllPending();
			session.setAttribute("pendingList", reimbursementPending);
			RequestDispatcher rd = request.getRequestDispatcher("ViewAllPending.jsp");
			rd.include(request, response);
			//out.println(reim.viewAllPending());
			
		}
		
		
		
		
	}

	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
