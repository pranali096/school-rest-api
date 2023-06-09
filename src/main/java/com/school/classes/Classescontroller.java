package com.school.classes;

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
@RequestMapping("/classes")
public class Classescontroller {

	@Autowired
	Classesservice classesservice;

	@PostMapping("/save")
	public ResponseEntity<?> addclasses(@RequestBody ClassesData dto) {

		return new ResponseEntity<>(classesservice.saveclasses(dto), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAllClasses() {
		return new ResponseEntity<>(classesservice.getAllClasses(), HttpStatus.OK);

	}

	@GetMapping("/pages")
	public ResponseEntity<?> getAllClassesByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination) {
		return new ResponseEntity<>(
				classesservice.getAllClassesByPagination(pageNo, pageSize, sortBy, sortOrder, isPagination),
				HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getClassesById(@PathVariable Long id) {
		return new ResponseEntity<>(classesservice.getClassesById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<?> deleteByid(@PathVariable Long cid) {
		return new ResponseEntity<>(classesservice.deleteById(cid), HttpStatus.OK);

	}

	@PutMapping("/updatedata")
	public ResponseEntity<?> updateClasses(@RequestBody ClassesData cdto) {
		return new ResponseEntity<>(classesservice.updatedata(cdto), HttpStatus.OK);

	}
}






