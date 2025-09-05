package com.FPBa3.FPB_A3_2025_2.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.FPBa3.FPB_A3_2025_2.Enum.TypeOfcomplaint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_complaint")
public class Complaint implements Serializable {

	private static final long serialVersionUID = 1L;
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private TypeOfcomplaint type;
	private String description;
	private LocalDateTime dateTime;
	private String location;
	private byte[] media;
	private User usuario;
	
	public Complaint() {
		
	}

	public Complaint(Integer id, TypeOfcomplaint type, String description, LocalDateTime dateTime, String location,
			byte[] media, User usuario) {
	
		this.id = id;
		this.type = type;
		this.description = description;
		this.dateTime = dateTime;
		this.location = location;
		this.media = media;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeOfcomplaint getType() {
		return type;
	}

	public void setType(TypeOfcomplaint type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getMedia() {
		return media;
	}

	public void setMedia(byte[] media) {
		this.media = media;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complaint other = (Complaint) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	}
	
	
}
