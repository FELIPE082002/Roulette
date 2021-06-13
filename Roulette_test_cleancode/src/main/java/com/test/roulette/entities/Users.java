package com.test.roulette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Users{
	
	@Id
	@Column(name="id_users")
	private String idUsers;
	@NotNull
	@Column(name="first_name")
	private String firstName;
	@NotNull
	@Column(name="last_name")
	private String lastName;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="founds")
	private int founds;
	
	public Users() {
		super();
	}

	public String getIdUser() {
		return idUsers;
	}

	public void setIdUser(String idUser) {
		this.idUsers = idUser;
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
