package com.conem.layouts.company.branch.employee.dto;

import com.conem.layouts.models.dtos.GenericDTO;

public class EmployeeDTO extends GenericDTO{

	private static final long serialVersionUID = -1L;
	
	private String branchId;
	
	private String branchName;
	
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String eMail;
	
	private String bloodType;
	
	private String knownDiseases;
	
	private String status;
	
	private String comments;
	
	private String type;

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getKnownDiseases() {
		return knownDiseases;
	}

	public void setKnownDiseases(String knownDiseases) {
		this.knownDiseases = knownDiseases;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
