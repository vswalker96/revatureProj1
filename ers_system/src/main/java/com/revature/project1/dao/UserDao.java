package com.revature.project1.dao;

import com.revature.project1.models.User;


public interface UserDao {
	
	//List<Users> getUsers = new ArrayList<Users>();
	
	
	
	User viewUser(int id);
	//based on this logins role id this should pull up a employee homepage or finance manager homepage
	User login(String username, String password); //getsAll users and returns the one that matches username and password input
	User logout(User user);
	
	//createUser
	
	

}
