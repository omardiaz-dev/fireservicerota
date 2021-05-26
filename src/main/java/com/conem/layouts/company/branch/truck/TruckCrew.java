package com.conem.layouts.company.branch.truck;

public class TruckCrew {

	private int commander;
	
	private int driver;
	
	private int backSeat;
	
	private String commanderName;
	
	private String driverName;
	
	private String backSeat1Name;
	
	private String backSeat2Name;
	

	public int getCommander() {
		return commander;
	}

	public void setCommander(int commander) {
		this.commander = commander;
	}

	public int getDriver() {
		return driver;
	}

	public void setDriver(int driver) {
		this.driver = driver;
	}

	public int getBackSeat() {
		return backSeat;
	}

	public void setBackSeat(int backSeat) {
		this.backSeat = backSeat;
	}
	
	public void incrementCommander() {
		commander = commander +1 ;
	}
	
	public void incrementBackSeatCrew() {
		backSeat = backSeat +1;
	}
	
	public void incrementDriver() {
		driver = driver +1;
	}
	
	public boolean isFullCrew() {
		boolean isFullCrew = false;
		if(driver != 1) {
			return false;
		}
		
		if(commander !=1) {
			return false;
		}
		
		if (backSeat == 2) {
			isFullCrew = true;
		}
		
		return isFullCrew;
			
	}

	public String getCommanderName() {
		if(commanderName==null) {
			return "";
		}
		return commanderName;
	}

	public void setCommanderName(String commanderName) {
		this.commanderName = commanderName;
	}

	public String getDriverName() {
		if(driverName==null) {
			return "";
		}
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBackSeat1Name() {
		if(backSeat1Name==null) {
			return "";
		}
		return backSeat1Name;
	}

	private void setBackSeat1Name(String backSeat1Name) {
		this.backSeat1Name = backSeat1Name;
	}

	public void setBackSeat(String name) {
		if(this.backSeat1Name == null) {
			setBackSeat1Name(name);
			return;
		}
		
		if(this.backSeat2Name == null) {
			setBackSeat2Name(name);
			return;
		}
		
	}
	
	public String getBackSeat2Name() {
		if(backSeat1Name==null) {
			return "";
		}
		return backSeat2Name;
	}

	private void setBackSeat2Name(String backSeat2Name) {
		this.backSeat2Name = backSeat2Name;
	}
	
	
}
