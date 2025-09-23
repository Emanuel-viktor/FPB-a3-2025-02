package com.FPBa3.FPB_A3_2025_2.resources;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.FPBa3.FPB_A3_2025_2.entities.Complaint;
import com.FPBa3.FPB_A3_2025_2.services.ComplaintService;

@RestController
@RequestMapping(value = "/complaints")
public class ComplaintResource {

	@Autowired
	private ComplaintService ComplaintService;

	@GetMapping
	public ResponseEntity<List<Complaint>> findAll() {

		List<Complaint> list = ComplaintService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Complaint> findById(@PathVariable Integer id) {
		Complaint obj = ComplaintService.findBYid(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping

	public ResponseEntity<Complaint> insert(@RequestBody Complaint obj) {
		obj = ComplaintService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		ComplaintService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/period")
	public List<Complaint> getEventosPorPeriodo(
	        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
	        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
	    return ComplaintService.buscarPorPeriodo(inicio, fim);
	}

	@GetMapping("/day")
	public List<Complaint> getEventosPorDia(
	        @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
	    return ComplaintService.buscarPorDia(data);
	}

}

	

