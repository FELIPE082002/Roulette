package com.test.roulette.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Roulettes {
	@Id
	private String idRoulettes;
	@NotNull
	private Boolean status;
	@NotNull
	private String idUsers_Users;
	
	public Roulettes() {
		super();
	}
	
	public String getIdRoulettes() {
		return idRoulettes;
	}
	public void setIdRoulettes(String idRoulettes) {
		this.idRoulettes = idRoulettes;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getIdUsers_Users() {
		return idUsers_Users;
	}
	public void setIdUsers_Users(String idUsers_Users) {
		this.idUsers_Users = idUsers_Users;
	}
	
	
}
