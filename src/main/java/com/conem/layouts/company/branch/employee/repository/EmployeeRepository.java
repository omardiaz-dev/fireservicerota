package com.conem.layouts.company.branch.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conem.layouts.company.branch.employee.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query("select u from Employee u where u.branchId = ?#{[0]}")
	List<Employee> findAllEmployeeByBranchId(Long id);
	
	
	@Query("select u from Employee u where u.employeeEmail = ?#{[0]}")
	Employee findAllEmployeeByEmail(String email);

}
