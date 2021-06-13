package com.test.roulette.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.entities.Roulettes;
import com.test.roulette.repositories.RoulettesRepository;
import com.test.roulette.services.IRoulettesService;

@Service
public class RoulettesServiceImpl implements IRoulettesService {

	@Autowired
	private RoulettesRepository repo;
	
	@Override
	public List<Roulettes> findAll() {
		return (List<Roulettes>) repo.findAll();
	}

}
