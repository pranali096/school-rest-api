package com.school.session;

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

import com.school.classes.Classes;

@RestController
@RequestMapping("/session")
public class SessionController {

	@Autowired
	SessionService sessionservice;
	
	@PostMapping
	public ResponseEntity<?>addSession(@RequestBody Session session){
		return new ResponseEntity<> (sessionservice.addSession(session),HttpStatus.OK);
		
	}
	
	@GetMapping("/sessionpages")
	public ResponseEntity<?>getAllSessionsByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam("sortorder") Direction sortOrder,
			@RequestParam(name = "isPagination", required = false, defaultValue = "1") int isPagination){
		
		return new ResponseEntity<> (sessionservice.getAllSessionsByPagination(pageNo, pageSize, sortBy, sortOrder, isPagination),HttpStatus.OK);
					
	}
	
	@PutMapping("/updatesessiondata")
	public ResponseEntity<?>updateSessions(@RequestBody Session session1 ){
		return new ResponseEntity<>(sessionservice.updatesissions(session1),HttpStatus.OK) ;
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable Integer id){
		return new ResponseEntity<>(sessionservice.deleteById(id),HttpStatus.OK);
		
	}
	


@GetMapping("/ses/{id1}")
public ResponseEntity<?> getSessionById(@PathVariable Integer id1){
	return new ResponseEntity<> (sessionservice.getSessionById(id1),HttpStatus.OK);
}
}