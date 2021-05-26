package com.conem.layouts.company.branch.employee.dto;

import com.conem.layouts.models.dtos.GenericDTO;

public class EmployeeScheduleDTO  extends GenericDTO{
	
	private static final long serialVersionUID = -1L;
	
	private String id;
	private String name;
	private String lastName;
	private String eMail;
	private String date;
	private String startTime;
	private String endTime;
	private char employeeType; 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public char getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(char employeeType) {
		this.employeeType = employeeType;
	}
	
	

}
