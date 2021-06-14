package com.test.roulette.services;

import java.util.List;

import com.test.roulette.dto.RoulettesDTO;


public interface IRoulettesService {
	public List<RoulettesDTO> findAll();
	public void save(RoulettesDTO roulette);
	public void update(Integer id);
}
