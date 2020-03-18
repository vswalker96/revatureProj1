package com.revature.project1.models;

import java.sql.Timestamp;
import java.util.Date;

public class Reimburserment {
	
	private int id;
	private double amount;
	private String description;
	private int statusId;
	private int typeId;
	private String receipt;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	private int createdBy;
	private int modifiedBy;
	private String cBFname;
	private String cBLname;
	
	
	
	
	
	
	

	public String getCBFname() {
		return cBFname;
	}
	
	public void setCBFname(String fname) {
		this.cBFname = fname;
	}
	
	public String getCBLname() {
		return cBLname;
	}

	public void setCBLname(String lname) {
		this.cBLname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "ID: " + id + "\nAmount: " + amount + "\nDescription: " + description + "\ntypeId: " + typeId
				+ "\nreceipt: " + receipt + "\nCreated On: " + createdOn + "\nModified On: " + modifiedOn + "\nCreated By: "
				+ createdBy + "\nModified By: " + modifiedBy;
	}
	
	

}
