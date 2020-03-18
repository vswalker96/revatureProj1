package com.revature.daoimplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.project1.dao.FinanceManagerDAO;
import com.revature.project1.jdbc.DatabaseConnection;
import com.revature.project1.models.User;

public class FinanceManagerDaoImpl implements FinanceManagerDAO {

	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String query = " ";

	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "select * from view_employees";
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			ArrayList<User> emp = new ArrayList<User>();
			
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String username = rs.getString("username");
				String email = rs.getString("email");
				int roleId = rs.getInt("role_id");
				
				User user = new User();
				
				user.setUserId(userId);
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setEmail(email);
				user.setRoleId(roleId);
				user.setUsername(username);
				
				emp.add(user);
				
						 
			}
			
			return emp;

		} catch (SQLException e) {
			System.out.println("This will be a logged exception");
			return null;
		}
		
		

	}

	public void updatePending(User user, int requestId, int status) {
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "update reimbursement set status_id = ?, modified_on = current_timestamp, modified_by = ? where id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, status);
			pstmt.setInt(2, user.getUserId());
			pstmt.setInt(3, requestId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("This will be a logger");
		}
		System.out.println("Request has been approved!");
	}

}
