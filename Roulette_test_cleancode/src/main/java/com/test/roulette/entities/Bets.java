package com.test.roulette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Bets {
	@Id
	private String idBets;
	
	@Column(name="BetValue")
	@NotNull
	private int betValue;
	
	@Column(name="Bet")
	@NotNull
	private String bet;
	
	@NotNull
	private boolean result;
	
	@Column(name="idRoulettes_Roulettes")
	private String idRoulettesRoulettes;

	public Bets() {
		super();
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

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getIdRoulettesRoulettes() {
		return idRoulettesRoulettes;
	}

	public void setIdRoulettesRoulettes(String idRoulettesRoulettes) {
		this.idRoulettesRoulettes = idRoulettesRoulettes;
	}
	
	
}
