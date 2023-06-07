package com.school.subject;

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
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectservice;
	
	@PostMapping("/save")
	public ResponseEntity<?> addSubject(@RequestBody Subject sub) {
		return new ResponseEntity<>(subjectservice.saveSubject(sub),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>updateSubject(@RequestBody Subject subject){
		return  new ResponseEntity<>(subjectservice.updateSubject(subject),HttpStatus.OK);
		
	}
	
	@GetMapping("/subjectpages")
	public ResponseEntity<?>getAllSubjectsByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination){
		
		return new ResponseEntity<> (subjectservice.getAllSubjectsByPagination(pageNo, pageSize, sortBy, sortOrder, isPagination),HttpStatus.OK);
					
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSubjectById(@PathVariable Long id) {
		return new ResponseEntity<>(subjectservice.deleteSubjectById(id), HttpStatus.OK);

	}
}