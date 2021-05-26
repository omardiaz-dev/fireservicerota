package com.conem.layouts.company.branch.truck;

public enum TruckStatusEnumeration {
	
	EMPTY("0"),
	FULL("1"),
	PARTIAL("2")
	;
	
	private String status;
	
	TruckStatusEnumeration( String status ) {
		this.status = status;
	}
	
	public String geStatus() {
		return status;
	}
	
}
