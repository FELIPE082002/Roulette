package com.test.roulette.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.dto.UsersDTO;
import com.test.roulette.entities.Users;
import com.test.roulette.repositories.UsersRepository;
import com.test.roulette.services.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {
	
	@Autowired
	private UsersRepository repo;

	@Override
	public List<UsersDTO> findAll() {
		List<UsersDTO> lstUsersDTO = new ArrayList<>();
		List<Users> lstUsers = (List<Users>) repo.findAll();
		for(Users u : lstUsers) {
			UsersDTO user = new UsersDTO();
			user.setIdUser(u.getIdUser());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setFounds(u.getFounds());
			user.setPassword(u.getPassword());
			lstUsersDTO.add(user);
		}
		return lstUsersDTO;
	}
	
	
}
