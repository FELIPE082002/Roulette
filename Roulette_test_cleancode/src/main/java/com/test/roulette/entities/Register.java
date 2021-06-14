package com.test.roulette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Register {
	
	@Id
	@Column(name="id_register")
	private int idRegister;
	
	@NotNull
	@Column(name="id_lastUser")
	private String idlastUser;

	public Register() {
		super();
	}

	public String getIdlastUser() {
		return idlastUser;
	}

	public void setIdlastUser(String idlastUser) {
		this.idlastUser = idlastUser;
	}

	public int getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
	}
	
	
	
}
