package com.conem.layouts.company.branch.truck;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import com.conem.layouts.company.branch.employee.Employee;
import com.conem.layouts.company.branch.employee.EmployeeSchedule;
import com.conem.layouts.company.branch.employee.EmployeeTypeEnum;
import com.conem.layouts.company.branch.employee.service.EmployeeScheduleService;
import com.conem.layouts.company.branch.employee.service.EmployeeService;
import com.conem.layouts.config.WebMvcConfig;


@Service
public class TruckService {
	
	private static final String START_SEARCH_TIME =" 00:01:01";
	private static final String END_SEARCH_TIME =" 23:59:59";
	
	public final EmployeeScheduleService employeeScheduleService;
	public final EmployeeService employeeService;
	
	private WebMvcConfig properties;
	
	ArrayList <HourAvailability> listTruck = new ArrayList<HourAvailability>();
	Hashtable<Integer, TruckCrew> hours = new Hashtable<Integer, TruckCrew>();
	List<String> header = new ArrayList<String>(); 
	
	TruckService(EmployeeScheduleService employeeScheduleService, EmployeeService employeeService,WebMvcConfig properties){
		this.employeeScheduleService = employeeScheduleService;
		this.employeeService = employeeService;
		this.properties = properties;
	}

	
	public List<HourAvailability> createListHours(Iterable<EmployeeSchedule> schedule, String startDate, String endDate ){
		
		HourAvailability hourAvailability =null;
		TruckCrew truckCrew = null;
		schedule = employeeScheduleService.findAllEmployeeByDate(startDate,endDate);
		boolean isFullTruck = isFullTruck( schedule);
		String hour;
		for (int i = 0; i < 24; i++) {
			hour = Integer.toString(i);
			if(hours.containsKey(i)) {
				truckCrew = hours.get(i);
			}
			
			if (hour.length()==1) {
				hour = "0" +hour;
			}
			hour = hour + ":00";
			
			if(truckCrew!=null && truckCrew.isFullCrew()) {
				hourAvailability = new HourAvailability(hour, TruckStatusEnumeration.FULL.geStatus(), truckCrew.getCommanderName() ,truckCrew.getDriverName(),truckCrew.getBackSeat1Name(), truckCrew.getBackSeat2Name());
			}else {
				if(truckCrew!=null) {
					hourAvailability = new HourAvailability(hour, TruckStatusEnumeration.PARTIAL.geStatus(),truckCrew.getCommanderName() ,truckCrew.getDriverName(),truckCrew.getBackSeat1Name(), truckCrew.getBackSeat2Name());	
				}else {
					hourAvailability = new HourAvailability(hour, TruckStatusEnumeration.EMPTY.geStatus(),"","","", "");	
				}
			}
			
			listTruck.add(hourAvailability);
			truckCrew = null;
		}
				
		return listTruck;
	}
	
	
	public static <T> List<T> iteratorToList(Iterator<T> iterator) {
	      List<T> list = new ArrayList<>();
	      while (iterator.hasNext()) {
	          list.add(iterator.next());
	      }
	      return list;
	}
	
	
	private boolean isFullTruck(Iterable<EmployeeSchedule> schedule) {
		boolean isFulltruck = false;
		EmployeeSchedule element = null;
		Employee employee = null;
		
		Integer keyHour = 0;
		
		Iterator itr = schedule.iterator();
		while(itr.hasNext()) {
		     element =(EmployeeSchedule) itr.next();
		     keyHour= element.getStartDate().getHours();
		     employee = employeeService.findOne(element.getEmployeeId());
		     if(hours.containsKey(keyHour)) {
		    	 TruckCrew truckCrew = hours.get(keyHour);
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.COMMANDER.getType())) {
		    		 truckCrew.incrementCommander();
		    		 truckCrew.setCommanderName(employee.getEmployeeName() + " " + employee.getEmployeeLastName() + TruckVolunteersTypeEnum.COMMANDER.getType());
		    	 }
		    	 
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.DRIVER.getType())) {
		    		 truckCrew.incrementDriver();
		    		 truckCrew.setDriverName(employee.getEmployeeName() + " " + employee.getEmployeeLastName() + TruckVolunteersTypeEnum.DRIVER.getType());
		    	 }
		    	 
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.BACK.getType())) {
		    		 truckCrew.incrementBackSeatCrew();
		    		 truckCrew.setBackSeat(employee.getEmployeeName() + " " + employee.getEmployeeLastName() +  TruckVolunteersTypeEnum.BACKSEAT.getType());
		    	 }
		    	 
		    	 isFulltruck = truckCrew.isFullCrew();
		     }else {
		    	 TruckCrew truckCrew = new TruckCrew();
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.COMMANDER.getType())) {
		    		 truckCrew.incrementCommander();
		    		 truckCrew.setCommanderName(employee.getEmployeeName() + " " + employee.getEmployeeLastName() + TruckVolunteersTypeEnum.COMMANDER.getType());
		    	 }
		    	 
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.DRIVER.getType())) {
		    		 truckCrew.incrementDriver();
		    		 truckCrew.setDriverName(employee.getEmployeeName() + " " + employee.getEmployeeLastName() + TruckVolunteersTypeEnum.DRIVER.getType());
		    	 }
		    	 
		    	 if(element.getVolunteerType().equals(EmployeeTypeEnum.BACK.getType())) {
		    		 truckCrew.incrementBackSeatCrew();
		    		 truckCrew.setBackSeat(employee.getEmployeeName() + " " + employee.getEmployeeLastName() +TruckVolunteersTypeEnum.BACKSEAT.getType());
		    	 }
		    	 hours.put(keyHour, truckCrew);
		     }
		}
		
		return isFulltruck;
	}
	
	
	public List<List<HourAvailability>> getInformationWeek(String date) {
		List<List<HourAvailability>> week = new ArrayList<List<HourAvailability>>();
		List <HourAvailability> listTruck, listTruck2;
		String startDate;
		String endDate;
		String day = "";
		String month = "";
		
		this.header.clear();
		this.listTruck.clear();
		hours.clear();
		
		if(date.equals("")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			LocalDateTime now = LocalDateTime.now(); 
			day =Integer.toString(now.getDayOfMonth());
			day = day.length()==1?"0"+day:day;
			month = Integer.toString(now.getMonthValue());
			month = month.length()==1?"0"+month:month;
			
			startDate = day + "/" + month+ "/" + Integer.toString(now.getYear()) + START_SEARCH_TIME;
			endDate = day + "/" + month + "/" + Integer.toString(now.getYear()) + END_SEARCH_TIME;
			
		}else {
			startDate = date.substring(8,10) + "/" + date.substring(5,7) + "/" +date.substring(0,4) + START_SEARCH_TIME;
			endDate = date.substring(8,10) + "/" + date.substring(5,7) + "/" +date.substring(0,4) + END_SEARCH_TIME;
		}
		
		Iterable<EmployeeSchedule> employeeSchedule = null;
		for (int i = 0; i <properties.getDashBoardDaysShow(); i++) {
			
			employeeSchedule = employeeScheduleService.findAllEmployeeByDate(startDate,endDate);
			listTruck = createListHours(employeeSchedule,startDate, endDate);
			week.add(listTruck);
			
			listTruck = null;
			this.listTruck = new ArrayList<HourAvailability>();
			employeeSchedule = null;
			hours.clear();
			header.add(startDate.substring(0, 10));
			startDate = getNextDate(startDate);
			endDate =  getNextDate(endDate);
			
		}
		return week;
	}
	
	
	public List<String> getHTMLTableHeader() {
		return header;
	}
	
	private String getNextDate(String startDate) {
		String sourceDate =startDate;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date myDate = null;;
		try {
			myDate = format.parse(sourceDate);
			myDate = addDays(myDate, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date date =myDate;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date); 
        strDate = strDate.substring(0, 10) + " " +startDate.substring(startDate.length()-8, startDate.length());
        
		return strDate;
	}
	
	
	 public static Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); 
	        return cal.getTime();
	    }
}
