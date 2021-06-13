package com.test.roulette.repositories;

import org.springframework.data.repository.CrudRepository;

import com.test.roulette.entities.Users;

public interface UsersRepository extends CrudRepository<Users, String>{
	
}
