package com.test.roulette.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.dto.BetsDTO;
import com.test.roulette.entities.Bets;
import com.test.roulette.repositories.BetsRepository;
import com.test.roulette.services.IBetsService;

@Service
public class BetsServiceImpl implements IBetsService {
	
	@Autowired
	private BetsRepository repo;
	
	@Override
	public List<BetsDTO> findAll() {
		List<BetsDTO> lstBetsDTO = new ArrayList<>();
		List<Bets> lstBets = (List<Bets>) repo.findAll();
		for(Bets b : lstBets) {
			BetsDTO bet = new BetsDTO();
			bet.setIdBets(b.getIdBets());
			bet.setBetValue(b.getBetValue());
			bet.setBet(b.getBet());
			bet.setResult(b.getResult());
			bet.setIdRoulettesRoulettes(b.getIdRoulettesRoulettes());
			lstBetsDTO.add(bet);
		}
		return lstBetsDTO;
	}

}
