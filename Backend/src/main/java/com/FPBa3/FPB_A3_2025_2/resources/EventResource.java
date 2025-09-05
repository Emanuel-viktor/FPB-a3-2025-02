package com.FPBa3.FPB_A3_2025_2.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FPBa3.FPB_A3_2025_2.entities.Event;

@RestController
@RequestMapping(value = "/events")
public class EventResource {
	
	@GetMapping
	public ResponseEntity<Event> findAll(){
		
		Event e = new Event(null, null, null, null, null, null, null);
		
		return ResponseEntity.ok().body(e);
		
	}
	

}
