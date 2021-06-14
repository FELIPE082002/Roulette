package com.test.roulette.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Bets {
	@Id
	@Column(name="id_bet")
	private int idBets;
	
	@Column(name="bet_value")
	@NotNull
	private Double betValue;
	
	@Column(name="bet")
	@NotNull
	private String bet;
	
	@NotNull
	@Column(name="result")
	private String result;
	
	@Column(name="id_roulettes_roulettes")
	private int idRoulettesRoulettes;

	public Bets() {
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
