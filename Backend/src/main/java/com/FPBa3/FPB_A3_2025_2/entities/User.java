package com.FPBa3.FPB_A3_2025_2.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private String email;
	private String senha;
	
	public User() {
		
	}

	public User(Integer id, String name, String email, String senha) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	

}
