package com.FPBa3.FPB_A3_2025_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FPBa3.FPB_A3_2025_2.entities.Event;
import com.FPBa3.FPB_A3_2025_2.repositories.EventRepository;
@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public List<Event> findAll(){
		return repository.findAll();
	}
	public Event findBYid(Integer id) {
		Optional <Event> obj = repository.findById(id);
		return obj.get();
	}

}
