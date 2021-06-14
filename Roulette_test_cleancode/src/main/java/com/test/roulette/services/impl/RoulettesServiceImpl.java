package com.test.roulette.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.roulette.dto.RoulettesDTO;
import com.test.roulette.entities.Roulettes;
import com.test.roulette.repositories.RoulettesRepository;
import com.test.roulette.services.IRoulettesService;

@Service
public class RoulettesServiceImpl implements IRoulettesService {

	@Autowired
	private RoulettesRepository repo;
	
	@Override
	public List<RoulettesDTO> findAll() {
		List<RoulettesDTO> lstRoulettesDTO = new ArrayList<>();
		List<Roulettes> lstRoulettes = (List<Roulettes>) repo.findAll();
		for(Roulettes r : lstRoulettes) {
			RoulettesDTO rlt = new RoulettesDTO();
			rlt.setIdRoulettes(r.getIdRoulettes());
			rlt.setStatus(r.getStatus());
			rlt.setIdUsers_Users(r.getIdUsers_Users());
			lstRoulettesDTO.add(rlt);
		}
		return lstRoulettesDTO;
	}

	@Override
	public void save(RoulettesDTO roulette) {
		Roulettes r = new Roulettes();
		r.setStatus(roulette.getStatus());
		r.setIdUsers_Users(roulette.getIdUsers_Users());
		repo.save(r);
	}

	
	@Override
	@Transactional
	public void update(Integer id) {
		repo.updateRoulette(id);
	}
}
