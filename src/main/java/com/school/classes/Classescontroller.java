package com.school.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolinfo.SchoolInfo;

@RestController
@RequestMapping("classes")
public class Classescontroller {

	@Autowired
	Classesservice classesservice;
	
	@PostMapping("/saveclasses")
	public ResponseEntity<?> addclasses(@RequestBody Classes classes) {
		
		return new ResponseEntity<>(classesservice.saveclasses(classes),HttpStatus.OK);
	}
}
