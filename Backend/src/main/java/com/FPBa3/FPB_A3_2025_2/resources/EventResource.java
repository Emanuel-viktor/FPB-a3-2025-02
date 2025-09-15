package com.FPBa3.FPB_A3_2025_2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FPBa3.FPB_A3_2025_2.entities.Event;
import com.FPBa3.FPB_A3_2025_2.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<List<Event>> findAll() {

		List<Event> list = eventService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Event> findById(@PathVariable Integer id) {
		Event obj = eventService.findBYid(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping

	public ResponseEntity<Event> insert(@RequestBody Event obj) {
		obj = eventService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		eventService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
