package com.conem.layouts.company.branch.employee;

public enum EmployeeTypeEnum {

	
	COMMANDER("0"),
	DRIVER("1"),
	BACK("2")
	;
	
	private String type;
	
	EmployeeTypeEnum( String type ) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
