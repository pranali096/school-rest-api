package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.school.entities.SchoolInfo;
import com.school.service.SchoolInfoService;

@RestController
@RequestMapping("school")
public class Schoolinfocontroller {

	@Autowired
	SchoolInfoService infoservice;
	
	
	@GetMapping
	public ResponseEntity<?>getAllSchoolInfo(){
		return new ResponseEntity<>(infoservice.getAllSchoolInfo(),HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<?> addSchoolInfo(@RequestBody SchoolInfo info) {
		
		return new ResponseEntity<>(infoservice.saveschoolinfo(info),HttpStatus.OK);
	}
	
		
}
