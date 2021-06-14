package com.test.roulette.services;



import com.test.roulette.dto.RegisterDTO;

public interface IRegisterService {
	public void save(String id);
	public RegisterDTO findId();
}
