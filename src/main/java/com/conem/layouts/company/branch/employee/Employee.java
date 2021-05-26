package com.conem.layouts.company.branch.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String employeeName;
	private String employeeLastName;
	private String employeeEmail;
	private String employeeBloodType;
	private String employeeDisease;
	private String employeeStatus;
	private String employeeBrigadistType;
	private String employeeComents;
	private Long branchId;
	
    public Employee clone()   {

    	Employee clon = new Employee(this.employeeId, this.employeeName, this.employeeLastName, this.employeeEmail,
    			this.employeeBloodType, this.employeeDisease, this.employeeStatus, this.employeeBrigadistType,
    			this.employeeComents, this.branchId);

        return clon;

     }

	public Employee() {
		super();
	}
	
	
	
	public Employee(Long employeeId, String employeeName, String employeeLastName, String employeeEmail,
			String employeeBloodType, String employeeDisease, String employeeStatus, String employeeBrigadistType,
			String employeeComents, Long branchId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.employeeBloodType = employeeBloodType;
		this.employeeDisease = employeeDisease;
		this.employeeStatus = employeeStatus;
		this.employeeBrigadistType = employeeBrigadistType;
		this.employeeComents = employeeComents;
		this.branchId = branchId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeBloodType() {
		return employeeBloodType;
	}
	public void setEmployeeBloodType(String employeeBloodType) {
		this.employeeBloodType = employeeBloodType;
	}
	public String getEmployeeDisease() {
		return employeeDisease;
	}
	public void setEmployeeDisease(String employeeDisease) {
		this.employeeDisease = employeeDisease;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public String getEmployeeBrigadistType() {
		return employeeBrigadistType;
	}
	public void setEmployeeBrigadistType(String employeeBrigadistType) {
		this.employeeBrigadistType = employeeBrigadistType;
	}
	public String getEmployeeComents() {
		return employeeComents;
	}
	public void setEmployeeComents(String employeeComents) {
		this.employeeComents = employeeComents;
	}
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	
	public Employee(Builder builder) {
		branchId = builder.branch_id;
		employeeName = builder.name;
		employeeLastName = builder.lastName;
		employeeEmail= builder.eMail;
		employeeBloodType = builder.bloodType;
		employeeDisease = builder.disease;
		employeeStatus = builder.status;
		employeeBrigadistType = builder.brigadistType;
		employeeComents = builder.coments;
	}
	
	public static class Builder{
		private final Long branch_id;
		private String name;
		private String lastName;
		private String eMail;
		private String bloodType;
		private String disease;
		private String status;
		private String brigadistType;
		private String coments;
		
		public Builder (Long branchId) {
			this.branch_id = branchId;
		}
		public Builder name(String val) {
			name = val;return this;
		}
		public Builder lastName(String val) {
			lastName= val;return this;
		}
		public Builder positon(String val) {
			eMail = val;return this;
		}
		public Builder bloodType(String val) {
			bloodType = val;return this;
		}
		public Builder disease(String val) {
			disease = val;return this;
		}
		public Builder status(String val) {
			status= val;return this;
		}
		public Builder brigadistType(String val) {
			brigadistType= val;return this;
		}
		public Builder coments(String val) {
			coments = val;return this;
		}
		
		public Employee build(){
			return new Employee(this);
		}
	}
	
}
