package com.revature.daoimplementations;

import com.revature.project1.dao.UserDao;
import com.revature.project1.models.User;
import com.revature.project1.jdbc.*;

import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDao {

	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String query = " ";
	public User myUser = new User();

	

	public User login(String username, String password) {
		// System.out.println(userName + " "+ password);
		User user = new User();
		user = null;
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();

			query = "select * from users where username =? and password=?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				myUser.setUserId(rs.getInt("user_id"));
				myUser.setFirstName(rs.getString("first_name"));
				myUser.setLastName(rs.getString("last_name"));
				myUser.setUsername(rs.getString("username"));
				myUser.setEmail(rs.getString("email"));
				myUser.setRoleId(rs.getInt("role_id"));
				user = myUser;

			} else {
				System.err.println("User does not exist");
				user = null;
			}

		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught UserDaoImpl.java: 85");
		}

		return user;

	}

	public User logout(User user) {
		user = myUser;
		myUser = null;

		return myUser;

	}
	
	public User viewUser(int id) {
		try {
			User user = new User();
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "select * from users where user_id =?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getString("first_name"));

				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				//user.setRoleId(rs.getInt("role_id"));
			
				
			}
			return user;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught UserDaoImpl.java: 111");
			return null;
		}
	}

	
}