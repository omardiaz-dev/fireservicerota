package com.conem.layouts.company.branch;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BranchRepository extends CrudRepository<Branch, Long>{
	
	@Query("select u from Branch u where u.companyId = ?#{[0]}")
	List<Branch> findBranchByCompanyId(Long id);
	

}


