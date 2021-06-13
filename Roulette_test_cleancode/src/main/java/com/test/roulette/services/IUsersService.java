package com.test.roulette.services;

import java.util.List;

import com.test.roulette.dto.SignInDTO;
import com.test.roulette.dto.UsersDTO;

public interface IUsersService {
	public List<UsersDTO> findAll();
	public void save(UsersDTO user);
	public SignInDTO validateUser(String email);
	public UsersDTO findById(String id);
}
