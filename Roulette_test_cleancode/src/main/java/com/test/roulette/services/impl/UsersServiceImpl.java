package com.test.roulette.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.entities.Users;
import com.test.roulette.repositories.UsersRepository;
import com.test.roulette.services.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {
	
	@Autowired
	private UsersRepository repo;

	@Override
	public List<Users> findAll() {
		return (List<Users>) repo.findAll();
	}
	
	
}
