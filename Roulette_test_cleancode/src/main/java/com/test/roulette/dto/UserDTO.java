package com.test.roulette.dto;


public class UserDTO {

	private String idUser;

	private String firstName;

	private String lastName;
	
	private String password;
	
	private int founds;
	
	public UserDTO(){
		
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
