package com.school.parent;

import java.security.PublicKey;

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
@RequestMapping("/parent")
public class ParentController {

	@Autowired 
	ParentService parentservice;
	

	
	@PostMapping
	public ResponseEntity<?> addparent(@RequestBody Parent parent) {
		
		return new ResponseEntity<>(parentservice.saveParent(parent),HttpStatus.OK);
	}
	
	@GetMapping("/parentpages")
	public ResponseEntity<?>getAllParentByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination){
		return new ResponseEntity<> (parentservice.getAllParentByPagination(pageNo, pageSize, sortBy, sortOrder, isPagination),HttpStatus.OK);
					
	}
	
	@PutMapping("/updateparentdata")
	public ResponseEntity<?>updateParent(@RequestBody Parent parents ){
		return new ResponseEntity<>(parentservice.saveParent(parents),HttpStatus.OK) ;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable Long id){
		return new ResponseEntity<>(parentservice.deleteById(id),HttpStatus.OK);
		
	}
}
