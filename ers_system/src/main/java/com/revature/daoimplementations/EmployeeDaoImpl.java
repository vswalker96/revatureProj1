package com.revature.daoimplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.jdbc.DatabaseConnection;
import com.revature.project1.models.User;

public class EmployeeDaoImpl implements EmployeeDAO{
	
	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String query = " ";
	
	
	public User viewUser(User user) {
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();

			query = "select * from users where user_id =?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, user.getUserId());
			rs = pstmt.executeQuery();
			User userDetails = new User();
			while (rs.next()) {
				userDetails.setUserId(rs.getInt("user_id"));
				userDetails.setFirstName(rs.getString("first_name"));
				userDetails.setLastName(rs.getString("last_name"));
				userDetails.setEmail(rs.getString(""));
				userDetails.setRoleId(rs.getInt("role_id"));
System.out.println(userDetails.toString());
				
			}
			return userDetails;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught UserDaoImpl.java: 111");
			return null;
		}
	}

	public void updateUser(User user) {
		Scanner scanner = new Scanner(System.in);
		try {
			String fname = user.getFirstName();
			String lname = user.getLastName();
			String email = user.getEmail();
			int userId = user.getUserId();
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "UPDATE users SET first_name = ?, last_name =?, email=?  WHERE user_id = ?";
			
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setInt(4, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught UserDaoImpl.java: 49");
		}
		Dashboard.logger.trace("User Details Updated! UserDaoImpl.java: 85");

	}
	

}
