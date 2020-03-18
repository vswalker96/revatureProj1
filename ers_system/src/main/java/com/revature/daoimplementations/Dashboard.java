package com.revature.daoimplementations;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.logging.log4j.*;

import com.revature.project1.models.*;

public class Dashboard {

	public static Logger logger = (Logger) LogManager.getLogger(Logger.class.getName());

	public static void main(String[] args) throws Exception {

//		logger.trace("Hello");
//
//		Scanner scanner = new Scanner(System.in);
//
		UserDaoImpl user = new UserDaoImpl();
//		FinanceManagerDaoImpl fm = new FinanceManagerDaoImpl();
//		ReimbursementDaoImpl reimb = new ReimbursementDaoImpl();
//		EmployeeDaoImpl emp = new EmployeeDaoImpl();
//
//		System.out.println("Username:");
//		String name = scanner.next();
//		System.out.println("password");
//		String pass = scanner.next();
//
		user.login("mwalker17", "abc@123");

		System.out.println("Logged in. ");

		//System.out.println(user.myUser.toString());

		System.out.println(user.viewUser(6));
		
		
		//reimb.viewMyPending(user.myUser);

		//reimb.viewAllPending();

		//reimb.viewAllResolved();

		//reimb.viewMyResolved(user.myUser);
		
//		User user1 = new User();
//		user1.setUserId(6);
		
		
		//emp.viewUser(6).toString();
		
		
		
	}
}


