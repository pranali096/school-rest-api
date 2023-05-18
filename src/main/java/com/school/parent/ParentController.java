package com.school.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired 
	ParentService parentservice;
	
	@GetMapping
	public ResponseEntity<?>getAllParentlist(){
		return new ResponseEntity<>(parentservice.getAllParentList(),HttpStatus.OK);
		
	}
}
