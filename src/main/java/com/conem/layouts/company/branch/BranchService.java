package com.conem.layouts.company.branch;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BranchService {
	
	private final BranchRepository branchRepository;
	
	public BranchService(BranchRepository branchRepository) {
	    this.branchRepository = branchRepository;
	}
	
	@Transactional
	public Branch save(Branch branch) {
		branchRepository.save(branch);
		return branch;
	}

    Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    public Branch findOne(Long id) {
        return branchRepository.findOne(id);
    }
    
    
    public Iterable<Branch> findAllByCompanyId(Long id) {
        return branchRepository.findBranchByCompanyId(id);
    }
    
}
