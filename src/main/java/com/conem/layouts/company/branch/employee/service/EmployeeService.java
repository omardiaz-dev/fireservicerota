package com.conem.layouts.company.branch.employee.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conem.layouts.account.Account;
import com.conem.layouts.company.branch.employee.Employee;
import com.conem.layouts.company.branch.employee.EmployeeTypeEnum;
import com.conem.layouts.company.branch.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@PostConstruct
	protected void initialize() {
		System.out.println("--------------PostContruct annotation - Saving Employees -----------------------");
		System.out.println("--------------PostContruct annotation - Saving Commander -----------------------");
		Employee employee = new Employee();
		employee.setBranchId(Long.valueOf("1"));
		employee.setEmployeeBloodType("A");
		employee.setEmployeeBrigadistType(EmployeeTypeEnum.COMMANDER.getType());
		employee.setEmployeeComents("Created for testing");
		employee.setEmployeeDisease("none");
		employee.setEmployeeEmail("commander@gmail.com");
		employee.setEmployeeName("commander name");
		employee.setEmployeeLastName("commander lastname");
		employee.setEmployeeStatus("1");
		System.out.println("--------------PostContruct annotation - Saving Commander -----------------------");

		employee.setEmployeeId(null);
		employee.setEmployeeEmail("driver@gmail.com");
		employee.setEmployeeName("driver name");
		employee.setEmployeeLastName("driver lastname");
		employee.setEmployeeBrigadistType(EmployeeTypeEnum.DRIVER.getType());
		Employee employee2 = employee.clone();
		
		employee.setEmployeeId(null);
		employee.setEmployeeEmail("backseat1@gmail.com");
		employee.setEmployeeName("backseat1 name");
		employee.setEmployeeLastName("backseat1 lastname");
		employee.setEmployeeBrigadistType(EmployeeTypeEnum.BACK.getType());
		Employee employee3 = employee.clone();
		
		employee.setEmployeeId(null);
		employee.setEmployeeEmail("backseat2@gmail.com");
		employee.setEmployeeName("backseat2 name");
		employee.setEmployeeLastName("backseat2 lastname");
		employee.setEmployeeBrigadistType(EmployeeTypeEnum.BACK.getType());
		Employee employee4 = employee.clone();
//		save(employee);
//		save(employee2);
//		save(employee3);
//		save(employee4);
	}
	
	@Transactional
	public Employee save(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	Iterable<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Employee findOne(Long id) {
		return employeeRepository.findOne(id);
	}
	
	public Iterable<Employee> findAllEmployeeByBranchId(Long id) {
		return employeeRepository.findAllEmployeeByBranchId(id);
	}
	
	public Employee findOne(String employeeEmail) {
		return employeeRepository.findAllEmployeeByEmail(employeeEmail);
	}
}
