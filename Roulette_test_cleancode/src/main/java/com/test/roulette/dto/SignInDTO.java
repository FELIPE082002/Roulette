package com.test.roulette.dto;

public class SignInDTO {
	
	private String id;
	private String email;
	private String password;
	private String vId;
	private String vEmail;
	private String vPassword;
	
	
	public SignInDTO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvPassword() {
		return vPassword;
	}

	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	
	
}
