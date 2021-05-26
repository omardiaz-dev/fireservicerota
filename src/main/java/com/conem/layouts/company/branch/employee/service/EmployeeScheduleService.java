package com.conem.layouts.company.branch.employee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.conem.layouts.company.branch.employee.EmployeeSchedule;
import com.conem.layouts.company.branch.employee.repository.EmployeeScheduleRepository;

@Service
public class EmployeeScheduleService {
	
	private final EmployeeScheduleRepository employeeScheduleRepository;
	

	public EmployeeScheduleService(EmployeeScheduleRepository employeeScheduleRepository) {
		this.employeeScheduleRepository = employeeScheduleRepository;
	}
	
	@Transactional
	public EmployeeSchedule save(EmployeeSchedule employeeSchedule) {
		employeeScheduleRepository.save(employeeSchedule);
		return employeeSchedule;
	}
	
	public Iterable<EmployeeSchedule> findAllEmployeeByDate(String startDate, String endDate) {
		return employeeScheduleRepository.findVolunteersByDate(startDate, endDate);
	} 
}
