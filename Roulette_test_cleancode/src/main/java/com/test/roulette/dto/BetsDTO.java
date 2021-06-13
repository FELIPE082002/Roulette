package com.test.roulette.dto;

public class BetsDTO {

	private String idBets;
	private int betValue;
	private String bet;
	private boolean result;
	
	public BetsDTO(){
		
	}

	public String getIdBets() {
		return idBets;
	}

	public void setIdBets(String idBets) {
		this.idBets = idBets;
	}

	public int getBetValue() {
		return betValue;
	}

	public void setBetValue(int betValue) {
		this.betValue = betValue;
	}

	public String getBet() {
		return bet;
	}

	public void setBet(String bet) {
		this.bet = bet;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
