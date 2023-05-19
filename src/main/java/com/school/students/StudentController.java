package com.school.students;

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

import com.school.divisions.Divisions;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@GetMapping
	public ResponseEntity<?> getAllStudents(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination) {
		return new ResponseEntity<>(studentservice.getAllStudents(pageNo, pageSize, sortBy, sortOrder, isPagination),
				HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<?> addStudents(@RequestBody Students std) {

		return new ResponseEntity<>(studentservice.saveStudents(std), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> UpdateStudents(@RequestBody Students stud) {
		return new ResponseEntity<>(studentservice.updateStudents(stud), HttpStatus.OK);

	}

	@GetMapping("/stud/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		return new ResponseEntity<>(studentservice.getStudentsById(id), HttpStatus.OK);

	}

	@DeleteMapping("/{sid}")
	public ResponseEntity<?> deleteStudentById(@PathVariable Integer sid) {
		return new ResponseEntity<>(studentservice.deleteStudentById(sid), HttpStatus.OK);

	}
}
