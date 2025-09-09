package com.FPBa3.FPB_A3_2025_2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FPBa3.FPB_A3_2025_2.entities.User;
import com.FPBa3.FPB_A3_2025_2.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);}
		
		@GetMapping(value= "/{id}")
		public ResponseEntity<User> findById(@PathVariable Integer id){
			User obj = userService.findBYid(id);
			return ResponseEntity.ok().body(obj);
		
		
	}
	

}
