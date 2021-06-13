package com.test.roulette.dto;


public class UsersDTO {

	private String idUser;

	private String email;
	
	private String firstName;

	private String lastName;
	
	private String password;
	
	private Double founds;
	
	public UsersDTO(){
		
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

	public Double getFounds() {
		return founds;
	}

	public void setFounds(Double founds) {
		this.founds = founds;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
