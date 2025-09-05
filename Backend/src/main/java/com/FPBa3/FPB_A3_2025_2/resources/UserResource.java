package com.FPBa3.FPB_A3_2025_2.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FPBa3.FPB_A3_2025_2.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(null, "adm1", "adm@gmail.com", "123456");
		
		return ResponseEntity.ok().body(u);
		
	}
	

}
