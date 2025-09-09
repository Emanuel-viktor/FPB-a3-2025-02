package com.FPBa3.FPB_A3_2025_2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FPBa3.FPB_A3_2025_2.entities.Event;
import com.FPBa3.FPB_A3_2025_2.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventResource {
	
	@Autowired
	private EventService eventService;
	@GetMapping
	public ResponseEntity<List<Event>> findAll(){
		
		
		List<Event> list = eventService.findAll();
		return ResponseEntity.ok().body(list);}
		
		@GetMapping(value= "/{id}")
		public ResponseEntity<Event> findById(@PathVariable Integer id){
			Event obj = eventService.findBYid(id);
			return ResponseEntity.ok().body(obj);
		
		
	}
	
	

}
