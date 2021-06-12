package com.test.roulette.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Users {
	
	@Id
	private String idUser;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String password;
	@NotNull
	private int founds;
	
	public Users() {
		super();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFounds() {
		return founds;
	}

	public void setFounds(int founds) {
		this.founds = founds;
	}
}
