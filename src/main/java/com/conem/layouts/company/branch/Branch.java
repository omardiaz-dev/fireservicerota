package com.conem.layouts.company.branch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//import com.conem.layouts.company.Company.Builder;



@Entity
@Table(name = "branch")
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
	
	//@NotEmpty
	private Long companyId;
	@NotEmpty
	@Column(unique = true)
	private String branchName="";
	private	String branchRegime="";
	private String branchLevels="";
	private String branchType ="";
	private String branchOpening="";
	private Integer branchYears;
	private String branchAreas="";
	private Long branchSurface;
	private Long branchBuiltSurface;
	private String branchNorthLatitude;
	private String branchWestLatitude;
	private String branchAltitude;
	private String branchNorthContiguity;
	private String branchSouthContiguity;
	private String branchEastContiguity;
	private String branchWestContiguity;
	private String branchStreet;
	private String branchNumExt;
	private String branchNumInt;
	private String branchNeighbor;
	private String branchLocation;
	private String branchCity;
	private String branchState;
	private String branchGroundSurface;
	private String branchMainActivity;
	private String branchBackgroundComments;
	private String branchBackgroundRegion;
	private String branchPreviousPipc;
	private String branchEmergencyPlan;
	private String branchEmergencyAlertSystem;
	private String branchRevisionExpirationDate;
	private String branchMorningStaff;
	private String branchAfternoomStaff;
	private String branchNighthlyStaff;
	private String branchMainCity = "";
	private String branchAlternateCity = "";
	private String branchWorkingDays = "";
	private String branchWorkersQty ="";
	private String branchDateConstitutionInternalUnit = "";
	private String branchConstitutionScheduleInternalUnit = "";
	
	
	
	
	public Branch(){
		  super();
	}
	
	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchRegime() {
		return branchRegime;
	}

	public void setBranchRegime(String branchRegime) {
		this.branchRegime = branchRegime;
	}

	public String getBranchLevels() {
		return branchLevels;
	}

	public void setBranchLevels(String branchLevels) {
		this.branchLevels = branchLevels;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getBranchOpening() {
		return branchOpening;
	}

	public void setBranchOpening(String branchOpening) {
		this.branchOpening = branchOpening;
	}

	public Integer getBranchYears() {
		return branchYears;
	}

	public void setBranchYears(Integer branchYears) {
		this.branchYears = branchYears;
	}

	public String getBranchAreas() {
		return branchAreas;
	}

	public void setBranchAreas(String branchAreas) {
		this.branchAreas = branchAreas;
	}

	public Long getBranchSurface() {
		return branchSurface;
	}

	public void setBranchSurface(Long branchSurface) {
		this.branchSurface = branchSurface;
	}

	public Long getBranchBuiltSurface() {
		return branchBuiltSurface;
	}

	public void setBranchBuiltSurface(Long branchBuiltSurface) {
		this.branchBuiltSurface = branchBuiltSurface;
	}

	public String getBranchNorthLatitude() {
		return branchNorthLatitude;
	}

	public void setBranchNorthLatitude(String branchNorthLatitude) {
		this.branchNorthLatitude = branchNorthLatitude;
	}

	public String getBranchWestLatitude() {
		return branchWestLatitude;
	}

	public void setBranchWestLatitude(String branchWestLatitude) {
		this.branchWestLatitude = branchWestLatitude;
	}

	public String getBranchAltitude() {
		return branchAltitude;
	}

	public void setBranchAltitude(String branchAltitude) {
		this.branchAltitude = branchAltitude;
	}

	public String getBranchNorthContiguity() {
		return branchNorthContiguity;
	}

	public void setBranchNorthContiguity(String branchNorthContiguity) {
		this.branchNorthContiguity = branchNorthContiguity;
	}

	public String getBranchSouthContiguity() {
		return branchSouthContiguity;
	}

	public void setBranchSouthContiguity(String branchSouthContiguity) {
		this.branchSouthContiguity = branchSouthContiguity;
	}

	public String getBranchEastContiguity() {
		return branchEastContiguity;
	}

	public void setBranchEastContiguity(String branchEastContiguity) {
		this.branchEastContiguity = branchEastContiguity;
	}

	public String getBranchWestContiguity() {
		return branchWestContiguity;
	}

	public void setBranchWestContiguity(String branchWestContiguity) {
		this.branchWestContiguity = branchWestContiguity;
	}
	
	public String getBranchStreet() {
		return branchStreet;
	}

	public void setBranchStreet(String branchStreet) {
		this.branchStreet = branchStreet;
	}

	public String getBranchNumExt() {
		return branchNumExt;
	}

	public void setBranchNumExt(String branchNumExt) {
		this.branchNumExt = branchNumExt;
	}

	public String getBranchNumInt() {
		return branchNumInt;
	}

	public void setBranchNumInt(String branchNumInt) {
		this.branchNumInt = branchNumInt;
	}

	public String getBranchNeighbor() {
		return branchNeighbor;
	}

	public void setBranchNeighbor(String branchNeighbor) {
		this.branchNeighbor = branchNeighbor;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchState() {
		return branchState;
	}

	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}

	public String getBranchGroundSurface() {
		return branchGroundSurface;
	}

	public void setBranchGroundSurface(String branchGroundSurface) {
		this.branchGroundSurface = branchGroundSurface;
	}

	public String getBranchMainActivity() {
		return branchMainActivity;
	}

	public void setBranchMainActivity(String branchMainActivity) {
		this.branchMainActivity = branchMainActivity;
	}

	public String getBranchBackgroundComments() {
		return branchBackgroundComments;
	}

	public void setBranchBackgroundComments(String branchBackgroundComments) {
		this.branchBackgroundComments = branchBackgroundComments;
	}

	public String getBranchBackgroundRegion() {
		return branchBackgroundRegion;
	}

	public void setBranchBackgroundRegion(String branchBackgroundRegion) {
		this.branchBackgroundRegion = branchBackgroundRegion;
	}

	public String getBranchPreviousPipc() {
		return branchPreviousPipc;
	}

	public void setBranchPreviousPipc(String branchPreviousPipc) {
		this.branchPreviousPipc = branchPreviousPipc;
	}

	public String getBranchEmergencyPlan() {
		return branchEmergencyPlan;
	}

	public void setBranchEmergencyPlan(String branchEmergencyPlan) {
		this.branchEmergencyPlan = branchEmergencyPlan;
	}

	public String getBranchEmergencyAlertSystem() {
		return branchEmergencyAlertSystem;
	}

	public void setBranchEmergencyAlertSystem(String branchEmergencyAlertSystem) {
		this.branchEmergencyAlertSystem = branchEmergencyAlertSystem;
	}

	public String getBranchRevisionExpirationDate() {
		return branchRevisionExpirationDate;
	}

	public void setBranchRevisionExpirationDate(String branchRevisionExpirationDate) {
		this.branchRevisionExpirationDate = branchRevisionExpirationDate;
	}

	public String getBranchMorningStaff() {
		return branchMorningStaff;
	}

	public void setBranchMorningStaff(String branchMorningStaff) {
		this.branchMorningStaff = branchMorningStaff;
	}

	public String getBranchAfternoomStaff() {
		return branchAfternoomStaff;
	}

	public void setBranchAfternoomStaff(String branchAfternoomStaff) {
		this.branchAfternoomStaff = branchAfternoomStaff;
	}

	public String getBranchNighthlyStaff() {
		return branchNighthlyStaff;
	}

	public void setBranchNighthlyStaff(String branchNighthlyStaff) {
		this.branchNighthlyStaff = branchNighthlyStaff;
	}
	public String getBranchMainCity() {
		return branchMainCity;
	}
	public void setBranchMainCity(String branch_main_city) {
		this.branchMainCity = branch_main_city;
	}
	public String getBranchAlternateCity() {
		return branchAlternateCity;
	}
	public void setBranchAlternateCity(String branch_alternate_city) {
		this.branchAlternateCity = branch_alternate_city;
	}
	public String getBranchWorkingDays() {
		return branchWorkingDays;
	}
	public void setBranchWorkingDays(String branch_working_days) {
		this.branchWorkingDays = branch_working_days;
	}
	public String getBranchWorkersQty() {
		return branchWorkersQty;
	}
	public void setBranchWorkersQty(String branch_workers_qty) {
		this.branchWorkersQty = branch_workers_qty;
	}
	public String getBranchDateConstitutionInternalUnit() {
		return branchDateConstitutionInternalUnit;
	}

	public void setBranchDateConstitutionInternalUnit(String branchDateConstitutionInternalUnit) {
		this.branchDateConstitutionInternalUnit = branchDateConstitutionInternalUnit;
	}

	public String getBranchConstitutionScheduleInternalUnit() {
		return branchConstitutionScheduleInternalUnit;
	}

	public void setBranchConstitutionScheduleInternalUnit(String branchConstitutionScheduleInternalUnit) {
		this.branchConstitutionScheduleInternalUnit = branchConstitutionScheduleInternalUnit;
	}



	private Branch(Builder builder) {
		companyId = builder.company_id;
		branchLevels = builder.levels;
		branchRegime = builder.regime;
		branchType= builder.type;
		branchOpening=builder.opening;
		branchYears = builder.years;
		branchAreas = builder.areas;
		branchSurface = builder.surface;
		branchBuiltSurface = builder.builtSurface;
		branchNorthLatitude = builder.northLatitude;
		branchWestLatitude = builder.westLatitude;
		branchAltitude = builder.altitude;
		branchNorthContiguity= builder.northContiguity;
		branchSouthContiguity= builder.southContiguity;
		branchEastContiguity= builder.eastContiguity;
		branchWestContiguity= builder.westContiguity;
		branchName=builder.name;
		branchStreet = builder.street;
		branchNumExt = builder.numExt;
		branchNumInt = builder.numInt;
		branchNeighbor = builder.neighbor;
		branchLocation = builder.location;
		branchCity = builder.city;
		branchState = builder.state;
		branchGroundSurface = builder.groundSurface;
		branchMainActivity = builder.mainActivity;
		branchBackgroundComments = builder.backgroundComments;
		branchBackgroundRegion = builder.backgroundRegion;
		branchPreviousPipc = builder.previousPipc;
		branchEmergencyPlan = builder.emergencyPlan;
		branchEmergencyAlertSystem = builder.emergencyAlertSystem;
		branchRevisionExpirationDate = builder.revisionExpirationDate;
		branchMorningStaff = builder.morningStaff;
		branchAfternoomStaff = builder.afternoomStaff;
		branchNighthlyStaff = builder.nighthlyStaff;
		branchMainCity = builder.mainCity;
		branchAlternateCity = builder.alternateCity;
		branchWorkingDays = builder.workingDays;
		branchWorkersQty = builder.workersQty;
		branchDateConstitutionInternalUnit = builder.dateConstitutionInternalUnit;
		branchConstitutionScheduleInternalUnit = builder.constitutionScheduleInternalUnit;
		
	}
	
	

	

	




	public static class Builder {
		// Required parameters
		private final Long company_id;
		private String regime;
		private String levels="";
		private String type;
		private String opening;
		private Integer years;
		private String areas;
		private Long surface;
		private Long builtSurface;
		private String northLatitude;
		private String westLatitude;
		private String altitude;
		private String northContiguity;
		private String southContiguity;
		private String eastContiguity;
		private String westContiguity;
		private String name;
		private String street;
		private String numExt;
		private String numInt;
		private String neighbor;
		private String location;
		private String city;
		private String state;
		private String groundSurface;
		private String mainActivity;
		private String backgroundComments;
		private String backgroundRegion;
		private String previousPipc;
		private String emergencyPlan;
		private String emergencyAlertSystem;
		private String revisionExpirationDate;
		private String morningStaff;
		private String afternoomStaff;
		private String nighthlyStaff;
		private String mainCity = "";
		private String alternateCity="";
		private String workingDays="";
		private String workersQty ="";
		private String dateConstitutionInternalUnit = "";
		private String constitutionScheduleInternalUnit = "";

		
	
		public Builder(Long companyId) {
			this.company_id = companyId;
		}
		
		public Builder levels(String val)
		{ 
			levels = val; return this; 
		}
		public Builder regime(String val)
		{ 
			regime = val; return this; 
		}
		public Builder type(String val)
		{ 
			type = val; return this; 
		}
		public Builder opening(String val)
		{ 
			opening = val; return this; 
		}
		public Builder 	years(String val)
		{ 
			if (val==null || val.equals("")) {
				val="0";
			}
			years = Integer.valueOf(val); return this; 
		}
		public Builder 	areas(String val)
		{ 
			areas = val; return this; 
		}
		public Builder 	surface(String val)
		{ 
			if (val==null || val.equals("")) {
				val="0";
			}
			surface = Long.valueOf(val); return this; 
		}
		public Builder 	builtSurface(String val)
		{ 	
			if (val==null || val.equals("")) {
				val="0";
			}
			builtSurface = Long.valueOf(val); return this; 
		}
		public Builder northLatitude(String val)
		{ 
			northLatitude = val; return this; 
		}
		public Builder westLatitude(String val)
		{ 
			westLatitude = val; return this; 
		}
		public Builder altitude(String val)
		{ 
			altitude = val; return this; 
		}
		public Builder northContiguity(String val)
		{ 
			northContiguity = val; return this; 
		}
		public Builder southContiguity(String val)
		{ 
			southContiguity = val; return this; 
		}
		public Builder eastContiguity(String val)
		{ 
			eastContiguity = val; return this; 
		}
		public Builder westContiguity(String val)
		{ 
			westContiguity = val; return this; 
		}
		public Builder name(String val)
		{ 
			name = val; return this; 
		}
		public Builder street(String val)
		{ 
			street = val; return this; 
		}
		public Builder numExt(String val)
		{ 
			numExt = val; return this; 
		}
		public Builder numInt(String val)
		{ 
			numInt = val; return this; 
		}
		public Builder neighbor(String val)
		{ 
			neighbor = val; return this; 
		}
		public Builder location(String val)
		{ 
			location = val; return this; 
		}
		public Builder city(String val)
		{ 
			city = val; return this; 
		}
		public Builder state(String val)
		{ 
			state = val; return this; 
		}
		public Builder groundSurface(String val)
		{ 
			groundSurface = val; return this; 
		}
		public Builder mainActivity(String val)
		{ 
			mainActivity = val; return this; 
		}
		public Builder backgroundComments(String val)
		{ 
			backgroundComments = val; return this; 
		}
		public Builder backgroundRegion(String val)
		{ 
			backgroundRegion = val; return this; 
		}
		public Builder previousPipc(String val)
		{ 
			previousPipc = val; return this; 
		}
		public Builder emergencyPlan(String val)
		{ 
			emergencyPlan = val; return this; 
		}
		public Builder emergencyAlertSystem(String val)
		{ 
			emergencyAlertSystem = val; return this; 
		}
		public Builder revisionExpirationDate(String val)
		{ 
			revisionExpirationDate = val; return this; 
		}
		public Builder morningStaff(String val)
		{ 
			morningStaff = val; return this; 
		}
		public Builder afternoomStaff(String val)
		{ 
			afternoomStaff = val; return this; 
		}
		public Builder nighthlyStaff(String val)
		{ 
			nighthlyStaff = val; return this; 
		}
		public Builder mainCity(String val)
		{ 
			mainCity = val; return this; 
		}
		public Builder alternateCity(String val)
		{ 
			alternateCity = val; return this; 
		}
		public Builder workingDays(String val)
		{ 
			workingDays = val; return this; 
		}
		public Builder workersQty(String val)
		{ 
			workersQty = val; return this; 
		}
		public Builder dateConstitutionInternalUnit(String val)
		{
			dateConstitutionInternalUnit = val; return this; 
		}
		public Builder constitutionScheduleInternalUnit(String val)
		{
			constitutionScheduleInternalUnit = val; return this;
		}

		
		
		
		
		
		public Branch build() {
			return new Branch(this);
		}
	}
	

}
