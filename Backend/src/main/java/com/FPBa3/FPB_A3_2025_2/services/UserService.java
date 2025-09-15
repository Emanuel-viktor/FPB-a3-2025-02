package com.FPBa3.FPB_A3_2025_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FPBa3.FPB_A3_2025_2.entities.User;
import com.FPBa3.FPB_A3_2025_2.repositories.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findBYid(Integer id) {
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}
	public User insert(User obj) {
		return repository.save(obj);
	}

}
