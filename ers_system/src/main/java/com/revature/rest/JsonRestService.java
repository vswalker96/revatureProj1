package com.revature.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.daoimplementations.ReimbursementDaoImpl;
import com.revature.project1.models.Reimburserment;




@Path("/reimbursement")
public class JsonRestService {
	
	@GET
	@Path("/pending")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reimburserment> getPending() {
		ReimbursementDaoImpl reimDaoImpl = new ReimbursementDaoImpl();
		
		ArrayList<Reimburserment> results = reimDaoImpl.viewAllPending();
		
		return results;
	}
	
	@GET
	@Path("/{id}/pending")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reimburserment> getOnePending(@PathParam("id") int id) {
		
		
		ReimbursementDaoImpl reimDaoImpl = new ReimbursementDaoImpl();
		
		ArrayList<Reimburserment> results = reimDaoImpl.viewMyPending(id);
		
		return results;
	}
	
	@GET
	@Path("/resolved")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reimburserment> getData() {
		ReimbursementDaoImpl reimDaoImpl = new ReimbursementDaoImpl();
		
		ArrayList<Reimburserment> results = reimDaoImpl.viewAllResolved();
		
		return results;
	}
	
	@GET
	@Path("/{id}/resolved")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reimburserment> getResolved(@PathParam("id") int id) {
		
		
		ReimbursementDaoImpl reimDaoImpl = new ReimbursementDaoImpl();
		
		ArrayList<Reimburserment> results = reimDaoImpl.viewMyResolved(id);
		
		return results;
	}
	
	

}

