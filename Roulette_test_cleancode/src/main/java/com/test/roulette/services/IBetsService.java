package com.test.roulette.services;

import java.util.List;

import com.test.roulette.dto.BetsDTO;

public interface IBetsService {
	public List<BetsDTO> findAll();
	public void createBet(BetsDTO bet);
	public List<BetsDTO> findByid(Integer id);
	public Integer generateNumber();
	public String generateColor(Integer num);
	public String betWin(String num,String bet,String color);
	public String typeBet(String bet);
	public Double winOrLose(String result,String typeBet,Double betValue,Double founds);
}
