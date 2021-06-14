package com.test.roulette.dto;

public class RegisterDTO {
	private String idlastUser;
	private int idRegister;

	public RegisterDTO() {
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
