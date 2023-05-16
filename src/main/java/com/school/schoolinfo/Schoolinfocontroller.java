package com.school.schoolinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class Schoolinfocontroller {

	@Autowired
	SchoolInfoService infoservice;
	
	
	@GetMapping
	public ResponseEntity<?>getAllSchoolInfo(){
		return new ResponseEntity<>(infoservice.getAllSchoolInfo(),HttpStatus.OK);
		
	}

	@PostMapping("/saveinfo")
	public ResponseEntity<?> addSchoolInfo(@RequestBody SchoolInfo info) {
		
		return new ResponseEntity<>(infoservice.saveschoolinfo(info),HttpStatus.OK);
	}
	@PutMapping("/updateinfo")
	public ResponseEntity<?>updateinfo(@RequestBody SchoolInfo sinfo){
		return new ResponseEntity<>(infoservice.updateschoolonfo(sinfo),HttpStatus.OK);
		
	}
	
}
