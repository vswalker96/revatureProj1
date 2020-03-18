package com.revature.project1.dao;

import java.util.ArrayList;

import com.revature.project1.models.Reimburserment;
import com.revature.project1.models.User;

public interface ReimbursementDAO {
	
	ArrayList<Reimburserment> viewMyPending(int id);
	ArrayList<Reimburserment> viewAllPending();
	ArrayList<Reimburserment> viewMyResolved(int id);
	ArrayList<Reimburserment> viewAllResolved(); 
	void createRequest(int userId, String description, String receipt, int typeId, double amount); //this inserts new request into the database 
	void viewSpecEmployee(int userId);

	
	
}
