package com.FPBa3.FPB_A3_2025_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FPBa3.FPB_A3_2025_2.entities.Complaint;
import com.FPBa3.FPB_A3_2025_2.repositories.ComplaintRepository;
@Service
public class ComplaintService {
	
	@Autowired
	private ComplaintRepository repository;
	
	public List<Complaint> findAll(){
		return repository.findAll();
	}
	public Complaint findBYid(Integer id) {
		Optional <Complaint> obj = repository.findById(id);
		return obj.get();
	}

}
