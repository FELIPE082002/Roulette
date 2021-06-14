package com.test.roulette.dto;

public class BetsDTO {

	private int idBets;
	private Double betValue;
	private String bet;
	private String result;
	private int idRoulettesRoulettes;
	
	public BetsDTO() {
		super();
	}
	
	public int getIdBets() {
		return idBets;
	}
	
	public void setIdBets(int idBets) {
		this.idBets = idBets;
	}
	
	public Double getBetValue() {
		return betValue;
	}
	
	public void setBetValue(Double betValue) {
		this.betValue = betValue;
	}
	
	public String getBet() {
		return bet;
	}
	
	public void setBet(String bet) {
		this.bet = bet;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public int getIdRoulettesRoulettes() {
		return idRoulettesRoulettes;
	}
	
	public void setIdRoulettesRoulettes(int idRoulettesRoulettes) {
		this.idRoulettesRoulettes = idRoulettesRoulettes;
	}
}
