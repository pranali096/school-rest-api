package com.school.branch;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;

public interface BranchService {

	public String addBranch(BranchRequestDto branch);
	
	public String getAllBranchesByPegination(Integer pageNo,Integer pageSize,String sortBy,Direction sortOrder,int isPagination);

	public String getBranchById(Long id);
	
	public String deleteByid(Long bid);
	
	public String updateByid(BranchDto bdto);
	

	public ResponseEntity<String> changePassword(ChangePasswordData pdata);
	
	
}
