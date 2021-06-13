package com.test.roulette.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.entities.Bets;
import com.test.roulette.repositories.BetsRepository;
import com.test.roulette.services.IBetsService;

@Service
public class BetsServiceImpl implements IBetsService {
	
	@Autowired
	private BetsRepository repo;
	
	@Override
	public List<Bets> findAll() {
		return (List<Bets>) repo.findAll();
	}

}
