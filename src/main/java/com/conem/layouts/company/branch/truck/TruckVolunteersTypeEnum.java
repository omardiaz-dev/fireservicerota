package com.conem.layouts.company.branch.truck;

public enum TruckVolunteersTypeEnum {

	COMMANDER("COMMANDER"),
	DRIVER("DRIVER"),
	BACKSEAT("BACKSEAT")
	;
	
	private String type;
	
	TruckVolunteersTypeEnum( String type ) {
		this.type = type;
	}
	
	public String getType() {
		return " (" + type + ") ";
	}
}
