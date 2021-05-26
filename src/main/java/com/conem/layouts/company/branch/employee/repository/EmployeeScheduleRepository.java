package com.conem.layouts.company.branch.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conem.layouts.company.branch.employee.EmployeeSchedule;

@Repository
public interface EmployeeScheduleRepository extends CrudRepository<EmployeeSchedule, Long> {

	@Query("select u "
			+ " from EmployeeSchedule u WHERE u.startDate BETWEEN  STR_TO_DATE(?1, '%d/%m/%Y %T')" + 
			" AND  STR_TO_DATE(?2, '%d/%m/%Y %T')")
	List<EmployeeSchedule> findVolunteersByDate(String startDate, String endDate);
	
}
