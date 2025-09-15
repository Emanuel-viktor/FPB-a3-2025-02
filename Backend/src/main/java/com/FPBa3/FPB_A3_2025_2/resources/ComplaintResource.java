package com.FPBa3.FPB_A3_2025_2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FPBa3.FPB_A3_2025_2.entities.Complaint;
import com.FPBa3.FPB_A3_2025_2.entities.User;
import com.FPBa3.FPB_A3_2025_2.services.ComplaintService;

@RestController
@RequestMapping(value = "/complaints")
public class ComplaintResource {
	

	@Autowired
	private ComplaintService ComplaintService;
	
	@GetMapping
	public ResponseEntity<List<Complaint>> findAll(){
		
		
		List<Complaint> list = ComplaintService.findAll();
		return ResponseEntity.ok().body(list);}
		
		@GetMapping(value= "/{id}")
		public ResponseEntity<Complaint> findById(@PathVariable Integer id){
			Complaint obj = ComplaintService.findBYid(id);
			return ResponseEntity.ok().body(obj);
		
		}
		
		@PostMapping
		
		public ResponseEntity<Complaint> insert(@RequestBody Complaint obj){
			obj = ComplaintService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
	}}
