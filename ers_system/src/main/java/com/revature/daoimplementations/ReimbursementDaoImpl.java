package com.revature.daoimplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Connection;
import java.util.Scanner;
import java.sql.Timestamp;

import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.jdbc.*;
import com.revature.project1.models.Reimburserment;
import com.revature.project1.models.User;

public class ReimbursementDaoImpl implements ReimbursementDAO {

	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String query = " ";

	public void createRequest(int userId, String description, String receipt, int typeId, double amount) {
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "insert into reimbursement (id, created_on, description, receipt, created_by, status_id, type_id, amount) values (REIMBURSEMENT_SEQ.nextval, CURRENT_TIMESTAMP,?, ?,?, 1, ?, ? )";

			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, description);
			pstmt.setString(2, receipt);
			pstmt.setInt(3, userId);
			pstmt.setInt(4, typeId);
			pstmt.setDouble(5, amount);
			pstmt.execute();
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 40");
		}
		System.out.println("Request created");

	}

	public ArrayList<Reimburserment> viewMyPending(int id) {
		
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "SELECT * FROM view_pending where created_by = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			ArrayList<Reimburserment> pending = new ArrayList<Reimburserment>();

			while (rs.next()) {

				int reimId = rs.getInt("id");
				int typeId = rs.getInt("type_id");
				String description = rs.getString("description");
				String receipt = rs.getString("receipt");
				double amount = rs.getDouble("amount");
				int createdById = rs.getInt("created_by");
				Timestamp createdOn = rs.getTimestamp("created_on");
				String cBFname = rs.getString("first_name");
				String cBLname = rs.getString("last_name");
				

				Reimburserment reim = new Reimburserment();
				reim.setId(reimId);
				reim.setTypeId(typeId);
				reim.setDescription(description);
				reim.setReceipt(receipt);
				reim.setAmount(amount);
				reim.setCreatedBy(createdById);
				reim.setCreatedOn(createdOn);
				reim.setCBFname(cBFname);
				reim.setCBLname(cBLname);
				

				
				pending.add(reim);
				
				System.out.println(pending.toString());
				
			
				
			}
			return pending;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 57");
			return null;
		}

//		while(rs.next()) {
//			System.out.println("RequestNo: " + rs.getInt("id") + "Created On: " + rs.getTimestamp("created_on") + "Descrip: " + rs.getString("description"));
//		}

	}

	public ArrayList<Reimburserment> viewAllPending() {
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "SELECT * FROM view_pending";
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();

			ArrayList<Reimburserment> pending = new ArrayList<Reimburserment>();

			while (rs.next()) {

				int reimId = rs.getInt("id");
				int typeId = rs.getInt("type_id");
				String description = rs.getString("description");
				String receipt = rs.getString("receipt");
				double amount = rs.getDouble("amount");
				int createdById = rs.getInt("created_by");
				Timestamp createdOn = rs.getTimestamp("created_on");
				String cBFname = rs.getString("first_name");
				String cBLname = rs.getString("last_name");

				Reimburserment reim = new Reimburserment();
				reim.setId(reimId);
				reim.setTypeId(typeId);
				reim.setDescription(description);
				reim.setReceipt(receipt);
				reim.setAmount(amount);
				reim.setCreatedBy(createdById);
				reim.setCreatedOn(createdOn);
				reim.setCBFname(cBFname);
				reim.setCBLname(cBLname);

				
				pending.add(reim);
				
				
				
			
				
			}

			return pending;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 74");
			return null;

		}
	}

	public ArrayList<Reimburserment> viewAllResolved() {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "SELECT * FROM view_resolved";
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();

			ArrayList<Reimburserment> resolved = new ArrayList<Reimburserment>();

			while (rs.next()) {

				int reimId = rs.getInt("id");
				int typeId = rs.getInt("type_id");
				String description = rs.getString("description");
				String receipt = rs.getString("receipt");
				double amount = rs.getDouble("amount");
				int createdById = rs.getInt("created_by");
				Timestamp createdOn = rs.getTimestamp("created_on");
				int modifiedBy = rs.getInt("modified_by");
				Timestamp modifiedOn = rs.getTimestamp("modified_on");
				String cBFname = rs.getString("first_name");
				String cBLname = rs.getString("last_name");

				Reimburserment reim = new Reimburserment();
				reim.setId(reimId);
				reim.setTypeId(typeId);
				reim.setDescription(description);
				reim.setReceipt(receipt);
				reim.setAmount(amount);
				reim.setCreatedBy(createdById);
				reim.setCreatedOn(createdOn);
				reim.setModifiedBy(modifiedBy);
				reim.setModifiedOn(modifiedOn);
				reim.setCBFname(cBFname);
				reim.setCBLname(cBLname);

				
				resolved.add(reim);
				
			}
			return resolved;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 87");
			return null;
		}

	}

	public ArrayList<Reimburserment> viewMyResolved(int userId) {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "SELECT * FROM view_resolved where created_by = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			ArrayList<Reimburserment> resolved = new ArrayList<Reimburserment>();

			while (rs.next()) {

				int reimId = rs.getInt("id");
				int typeId = rs.getInt("type_id");
				String description = rs.getString("description");
				String receipt = rs.getString("receipt");
				double amount = rs.getDouble("amount");
				int createdById = rs.getInt("created_by");
				Timestamp createdOn = rs.getTimestamp("created_on");
				int modifiedBy = rs.getInt("modified_by");
				Timestamp modifiedOn = rs.getTimestamp("modified_on");
				String cBFname = rs.getString("first_name");
				String cBLname = rs.getString("last_name");

				Reimburserment reim = new Reimburserment();
				reim.setId(reimId);
				reim.setTypeId(typeId);
				reim.setDescription(description);
				reim.setReceipt(receipt);
				reim.setAmount(amount);
				reim.setCreatedBy(createdById);
				reim.setCreatedOn(createdOn);
				reim.setModifiedBy(modifiedBy);
				reim.setModifiedOn(modifiedOn);
				
				reim.setCBFname(cBFname);
				reim.setCBLname(cBLname);

				
				resolved.add(reim);
				
			}
			
			return resolved;
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 102");
			return null;
		}
	}

	public void viewSpecEmployee(int userId) {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection conn = DatabaseConnection.getInstance();
			Connection connection = conn.getConnection();
			query = "SELECT * FROM view_employees where user_id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("YEAA BABBYYYYY");
			}
		} catch (SQLException e) {
			Dashboard.logger.trace("SQL Exception caught ReimbursementDaoImpl.java: 116");
		}

	}
}
