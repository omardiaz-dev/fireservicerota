package com.conem.layouts.company.branch.employee;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeSchedule")
public class EmployeeSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Long employeeId;
	private Date startDate;
	private Date endDate;
	private String volunteerType;
	private byte fireTruckNumber;
	
		
	public EmployeeSchedule() {
			
	}
	
	
	public EmployeeSchedule(Long id, Long employeeId, Date startDate, Date endDate, String volunteerType,	byte fireTruckNumber) {
		super();
		Id = id;
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.volunteerType = volunteerType;
		this.fireTruckNumber = fireTruckNumber;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getVolunteerType() {
		return volunteerType;
	}

	public void setVolunteerType(String volunteerType) {
		this.volunteerType = volunteerType;
	}

	public byte getFireTruckNumber() {
		return fireTruckNumber;
	}

	public void setFireTruckNumber(byte fireTruckNumber) {
		this.fireTruckNumber = fireTruckNumber;
	}
	
	
	
}
