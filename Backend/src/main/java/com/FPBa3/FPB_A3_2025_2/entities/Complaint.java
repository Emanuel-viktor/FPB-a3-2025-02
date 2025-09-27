package com.FPBa3.FPB_A3_2025_2.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.FPBa3.FPB_A3_2025_2.Enum.TypeOfcomplaint;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name="tb_complaint")
public class Complaint implements Serializable {

	private static final long serialVersionUID = 1L;
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer type;
	private String description;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateTime;
	private String location;
	private byte[] media;
	@ManyToOne
	@JoinColumn(name = "TB_USER/ID")
	@JsonIgnoreProperties({"event", "complaint"}) 
	
	private User usuario;
	
	public Complaint() {
		
	}

	public Complaint(Integer id, TypeOfcomplaint type, String description, LocalDateTime dateTime, String location,
			byte[] media, User usuario) {
	
		this.id = id;
		setType(type);
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

	public TypeOfcomplaint getType() throws IllegalAccessException {
		return TypeOfcomplaint.valueOf(type) ;
	}

	public void setType(TypeOfcomplaint type) {
		if(type!=null) {
		this.type = type.getCode();}
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
