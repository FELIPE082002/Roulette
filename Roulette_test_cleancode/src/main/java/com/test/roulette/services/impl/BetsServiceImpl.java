package com.test.roulette.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public void createBet(BetsDTO bet) {
		Bets bets = new Bets();
		bets.setBet(bet.getBet());
		bets.setBetValue(bet.getBetValue());
		bets.setResult(bet.getResult());
		bets.setIdRoulettesRoulettes(bet.getIdRoulettesRoulettes());
		repo.save(bets);
	}

	@Override
	public List<BetsDTO> findByid(Integer id) {
		List<Object[]> lst = repo.betsByUser(id);
		List<BetsDTO> lstBetsDTO = new ArrayList<BetsDTO>();
		for(Object[] obj : lst) {
			BetsDTO b = new BetsDTO();
			b.setIdBets(Integer.parseInt(obj[0].toString()));
			b.setBetValue(Double.valueOf(obj[1].toString()));
			b.setBet(obj[2].toString());
			b.setResult(obj[3].toString());
			lstBetsDTO.add(b);
		}
		return lstBetsDTO;
	}

	@Override
	public Integer generateNumber() {
		Random r = new Random();
		int num = r.nextInt(36);
		return num;
	}

	@Override
	public String generateColor(Integer num) {
		String color;
		if(num%2==0) {
			color = "Red,";
		}else {
			color = "Black,";
		}
		return color;
	}

	

}
