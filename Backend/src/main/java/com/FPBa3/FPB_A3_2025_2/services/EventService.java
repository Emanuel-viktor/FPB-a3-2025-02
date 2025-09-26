package com.FPBa3.FPB_A3_2025_2.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	public List<Event> findAll() {
		return repository.findAll();
	}

	public Event findBYid(Integer id) {
		Optional<Event> obj = repository.findById(id);
		return obj.get();
	}

	public Event insert(Event obj) {
		return repository.save(obj);
	}
	public void delete(Integer id) {
		repository.deleteById(id);  
	}
	public List<Event> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
	    return repository.findByDateTimeBetween(inicio, fim);
	}

	public List<Event> buscarPorDia(LocalDate data) {
	    return repository.findByDia(data);
	}
	public Event update(Integer id,Event obj) {
		Event entity = repository.getReferenceById(id);
		return repository.save(entity);
	}
	private void updateData(Event entity, Event obj) {
		
		entity.setDateTime(obj.getDateTime());
		entity.setDescription(obj.getDescription());
		entity.setLocation(obj.getLocation());
		entity.setName(obj.getName());
		entity.setPoster(obj.getPoster());
	}

}
