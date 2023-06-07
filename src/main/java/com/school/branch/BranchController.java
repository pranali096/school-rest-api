package com.school.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Branch")
public class BranchController {
	
	@Autowired
	BranchService branchservice;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<?> addBranch(@RequestBody BranchRequestDto branch) {
		return new ResponseEntity<>(branchservice.addBranch(branch),HttpStatus.OK);
	}

	@GetMapping("/pages")
	public ResponseEntity<?> getAllBranchesByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination) {
		return new ResponseEntity<>(branchservice.getAllBranchesByPegination(pageNo, pageSize, sortBy, sortOrder, isPagination),HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBranchById(@PathVariable Long id) {
		return new ResponseEntity<>(branchservice.getBranchById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{bid}")
	public ResponseEntity<?> deleteByid(@PathVariable Long bid) {
		return new ResponseEntity<>(branchservice.deleteByid(bid), HttpStatus.OK);

	}

	@PutMapping("/updatedata")
	public ResponseEntity<?> updateBranch(@RequestBody BranchDto bdto) {
		return new ResponseEntity<>(branchservice.updateByid(bdto), HttpStatus.OK);

	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<?> updateBranch(@RequestBody ChangePasswordData pdata) {
		return new  ResponseEntity<>(branchservice.changePassword(pdata),HttpStatus.OK);
		
	}

	
	
}
