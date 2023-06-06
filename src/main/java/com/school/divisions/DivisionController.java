package com.school.divisions;

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
@RequestMapping("/division")
public class DivisionController {

	@Autowired
	Divisionservices divservices;
	

@GetMapping
public ResponseEntity<?>getAllDivisions(@RequestParam(defaultValue = "0") Integer pageNo,
		@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
		@RequestParam("sortorder") Direction sortOrder,
		@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination){
	return new ResponseEntity<> (divservices.getAllDivisions(pageNo, pageSize, sortBy, sortOrder, isPagination),HttpStatus.OK);
				
}
@PostMapping
public ResponseEntity<?> addDivisions(@RequestBody Divisions div) {
	
	return new ResponseEntity<>(divservices.saveDivisions(div),HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<?> getDivisionById(@PathVariable Long id){
	return new ResponseEntity<> (divservices.getDivisionById(id),HttpStatus.OK);
	
	
}

@PutMapping
public ResponseEntity<?> UpdateDivision(@RequestBody Divisions divi){
	return new ResponseEntity<> (divservices.updateDivision(divi),HttpStatus.OK);
		
}


@DeleteMapping("/{did}")
public ResponseEntity<?> deleteByid(@PathVariable Long did){
	return new ResponseEntity<>(divservices.deleteById(did),HttpStatus.OK);
	
}
}
