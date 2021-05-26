package com.conem.layouts.company.branch.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.conem.layouts.Application;
import com.conem.layouts.account.AccountService;
import com.conem.layouts.company.branch.Branch;
import com.conem.layouts.company.branch.BranchService;
import com.conem.layouts.company.branch.employee.Employee;
import com.conem.layouts.company.branch.employee.EmployeeSchedule;
import com.conem.layouts.company.branch.employee.dto.EmployeeDTO;
import com.conem.layouts.company.branch.employee.dto.EmployeeScheduleDTO;
import com.conem.layouts.company.branch.employee.service.EmployeeScheduleService;
import com.conem.layouts.company.branch.employee.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final EmployeeScheduleService employeeScheduleService;
	private final BranchService branchService;
	
	EmployeeController(EmployeeScheduleService employeeScheduleService,EmployeeService employeeService, BranchService branchService){
		this.employeeService = employeeService;
		this.branchService = branchService;
		this.employeeScheduleService = employeeScheduleService;
	}

	@GetMapping("/employeeAdd")
	public String employeeAddGet(Model model,@RequestParam(defaultValue = "") String branch_id, @RequestParam(defaultValue = "") String branch_name) {
		model.addAttribute("branch_id", branch_id);
		model.addAttribute("branch_name", branch_name);
		model.addAttribute("employee_email", AccountService.globalUser.getEmail());
		if (AccountService.isAdmin()){
    		model.addAttribute("admin", "TRUE");
    	}else {
    		model.addAttribute("admin", "FALSE");
    	}
		return "employee/employeeAdd";
	}
	
	@RequestMapping(value = "employeeAdd", method = RequestMethod.POST)
	public String postEmployee(Model model,@ModelAttribute EmployeeDTO employeeDTO,
											 @RequestParam(defaultValue = "") String action) {

		Employee employee = null;
		if (Application.ACTION_CANCEL.equals(action)) {
			return "redirect:/"; 
		}
		
		if(employeeDTO.getId()!=null) {
			employee = employeeService.findOne(employeeDTO.getId());
			employee.setEmployeeName(employeeDTO.getName());
			employee.setEmployeeLastName(employeeDTO.getLastName());
			employee.setEmployeeEmail(employeeDTO.geteMail());
			employee.setEmployeeBloodType(employeeDTO.getBloodType());
			employee.setEmployeeDisease(employeeDTO.getKnownDiseases());
			employee.setEmployeeStatus(employeeDTO.getStatus());
			employee.setEmployeeBrigadistType(employeeDTO.getType());
			employee.setEmployeeComents(employeeDTO.getComments());
			employeeService.save(employee);
			}	
		else {
			employee = new Employee.Builder(Long.parseLong(employeeDTO.getBranchId()))
					.name(employeeDTO.getName())
					.lastName(employeeDTO.getLastName())
					.positon(employeeDTO.geteMail())
					.bloodType(employeeDTO.getBloodType())
					.disease(employeeDTO.getKnownDiseases())
					.status(employeeDTO.getStatus())
					.brigadistType(employeeDTO.getType())
					.coments(employeeDTO.getComments())
					.build();
			employeeService.save(employee);
		}
				
		//return "redirect:/branch/" +branch_id+"?moduleMessage=Empleados";
		return "redirect:/employeeList?branch_id=1&branch_name=Main Station";
	}
	
	@GetMapping(value = "employeeList")
	public String employeeList(Model model,@RequestParam(defaultValue = "") String branch_id,
								   			   @RequestParam(defaultValue = "") String branch_name,
								               @RequestParam(defaultValue = "") String action
								   ) {
		if (Application.ACTION_EMPLOYEE.equals(action)) {
			return "redirect:/employeeAdd?branch_id=" +branch_id +"&branch_name=" +branch_name+".";
		}
		if (Application.ACTION_CANCEL.equals(action)) {
			return "redirect:/"; 
		}
		model.addAttribute("branch_id", branch_id);
		model.addAttribute("branch_name", branch_name);
		model.addAttribute("employee", employeeService.findAllEmployeeByBranchId(Long.parseLong(branch_id)));
		model.addAttribute("messageTask", "Please select a Volunteer from " + branch_name+".");
		model.addAttribute("employees", employeeService.findAllEmployeeByBranchId(Long.parseLong(branch_id)));
				
		if (AccountService.isAdmin()){
    		model.addAttribute("admin", "TRUE");
    	}else {
    		model.addAttribute("admin", "FALSE");
    	}
		
		return "employee/employeeList";
	}
	
	@RequestMapping(value =  "employee/{id}", method = RequestMethod.GET)
	public String employeeShow(@PathVariable("id") Long id, Model model,@RequestParam(defaultValue = "")String employee_id) {
		Employee employee = employeeService.findOne(id);
	
		model.addAttribute("employee_id", employee.getEmployeeId());
		model.addAttribute("employee_name", employee.getEmployeeName());
		model.addAttribute("employee_last_name", employee.getEmployeeLastName());
		model.addAttribute("employee_email", employee.getEmployeeEmail());
		model.addAttribute("employee_blood_type", employee.getEmployeeBloodType());
		model.addAttribute("employee_disease", employee.getEmployeeDisease());
		model.addAttribute("employee_status", employee.getEmployeeStatus());
		model.addAttribute("employee_brigadist_type", employee.getEmployeeBrigadistType());
		model.addAttribute("employee_coments", employee.getEmployeeComents());
		
		
		return "employee/employeeAdd";
	}
	
	@RequestMapping(value =  "employee/{id}", method = RequestMethod.POST)
	public String employeeShow2(@PathVariable("id") Long id, Model model,@RequestParam(defaultValue = "")String employee_id) {
		Employee employee = employeeService.findOne(id);
		Branch branch = branchService.findOne(employee.getBranchId());
		model.addAttribute("branch_name", branch.getBranchName());
		model.addAttribute("branch_id", employee.getBranchId());
		model.addAttribute("employee_id", employee.getEmployeeId());
		model.addAttribute("employee_name", employee.getEmployeeName());
		model.addAttribute("employee_last_name", employee.getEmployeeLastName());
		model.addAttribute("employee_email", employee.getEmployeeEmail());
		model.addAttribute("employee_blood_type", employee.getEmployeeBloodType());
		model.addAttribute("employee_disease", employee.getEmployeeDisease());
		model.addAttribute("employee_status", employee.getEmployeeStatus());
		model.addAttribute("employee_brigadist_type", employee.getEmployeeBloodType());
		model.addAttribute("employee_coments", employee.getEmployeeComents());
		
		
		return "employee/employeeAdd";
	}

	
	@GetMapping("/volunteerSchedule")
	public String volunteerSchedule(Model model,@RequestParam(defaultValue = "") String branch_id, @RequestParam(defaultValue = "") String branch_name) {
		Employee employee = employeeService.findOne(AccountService.globalUser.getEmail());
		
		model.addAttribute("employee_id", employee.getEmployeeId());
		model.addAttribute("employee_name", employee.getEmployeeName());
		model.addAttribute("employee_last_name", employee.getEmployeeLastName());
		model.addAttribute("employee_email", employee.getEmployeeEmail());
		return "employee/volunteerSchedule";
	}
	
	@RequestMapping(value = "addSchedule", method = RequestMethod.POST)
	public String addSchedule(Model model,@ModelAttribute EmployeeScheduleDTO employeeScheduleDTO,
											 @RequestParam(defaultValue = "") String action) throws ParseException {

		Employee employee = null;
		EmployeeSchedule schedule = new EmployeeSchedule();
		
		String sDate = employeeScheduleDTO.getDate() + " "  + employeeScheduleDTO.getStartTime();
		String eDate = employeeScheduleDTO.getDate() + " "  + employeeScheduleDTO.getEndTime();
		
		if (Application.ACTION_CANCEL.equals(action)) {
			return "redirect:/"; 
		}
		
		employee = employeeService.findOne(employeeScheduleDTO.geteMail());
		if (employee !=null) {
			Date startDate=new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(sDate);  
			Date endDate=new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(eDate);  
			schedule.setEmployeeId(Long.valueOf(employeeScheduleDTO.getId()));
			schedule.setEndDate(endDate);
			schedule.setStartDate(startDate);
			schedule.setVolunteerType(employee.getEmployeeBrigadistType());
			schedule.setFireTruckNumber(Byte.valueOf("1"));
			
			employeeScheduleService.save(schedule);
		}
		
		return "redirect:/employeeList?branch_id=1&branch_name=Main Station";
	}
	
	
	
}
