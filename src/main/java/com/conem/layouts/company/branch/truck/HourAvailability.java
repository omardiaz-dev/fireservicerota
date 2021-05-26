package com.conem.layouts.company.branch.truck;

public class HourAvailability {
	
	private String hour;
	
	private String status;
	
	private String driverName;
	
	private String commanderName;
	
	private String backSeat1Name;
	
	private String backSeat2Name;
	
	
	
	public HourAvailability(String hour, String status, String commanderName, String driverName, String backSeatName1, String backSeatName2) {
		super();
		this.hour = hour;
		this.status = status;
		this.commanderName = commanderName;
		this.driverName = driverName;
		this.backSeat1Name = backSeatName1;
		this.backSeat2Name = backSeatName2;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCommanderName() {
		return commanderName;
	}

	public void setCommanderName(String commanderName) {
		this.commanderName = commanderName;
	}

	public String getBackSeat1Name() {
		return backSeat1Name;
	}

	public void setBackSeat1Name(String backSeat1Name) {
		this.backSeat1Name = backSeat1Name;
	}

	public String getBackSeat2Name() {
		return backSeat2Name;
	}

	public void setBackSeat2Name(String backSeat2Name) {
		this.backSeat2Name = backSeat2Name;
	}
	
	
}
