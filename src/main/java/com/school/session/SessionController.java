package com.school.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
