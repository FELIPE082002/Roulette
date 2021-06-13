package com.test.roulette.services;

import java.util.List;

import com.test.roulette.dto.BetsDTO;

public interface IBetsService {
	public List<BetsDTO> findAll();
}
