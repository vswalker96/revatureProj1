package com.revature.project1.dao;

import java.util.ArrayList;

import com.revature.project1.models.User;

public interface FinanceManagerDAO {
	
	ArrayList<User> getUsers();
	void updatePending(User user, int requestId, int status);

}
