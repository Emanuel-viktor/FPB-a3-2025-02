package com.FPBa3.FPB_A3_2025_2.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public Complaint insert(Complaint obj) {
		return repository.save(obj);
	}
	public void delete(Integer id) {
		repository.deleteById(id);  
	}
	public List<Complaint> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
	    return repository.findByDateTimeBetween(inicio, fim);
	}

	public List<Complaint> buscarPorDia(LocalDate data) {
	    return repository.findByDia(data);
	}
	public Complaint update(Integer id,Complaint obj) {
		Complaint entity=repository.getReferenceById(id);
		return repository.save(entity);	
	}
	public void updateData(Complaint entity, Complaint obj) throws IllegalAccessException {
		entity.setDateTime(obj.getDateTime());
		entity.setDescription(obj.getDescription());
		entity.setLocation(obj.getLocation());
		entity.setType(obj.getType());
		
	}
}
