package com.test.roulette.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.dto.BetsDTO;
import com.test.roulette.dto.RegisterDTO;
import com.test.roulette.dto.RoulettesDTO;
import com.test.roulette.dto.UsersDTO;
import com.test.roulette.services.IBetsService;
import com.test.roulette.services.IRegisterService;
import com.test.roulette.services.IRoulettesService;
import com.test.roulette.services.IUsersService;

@Controller
public class BetController {
	@Autowired
	IBetsService betService;
	@Autowired
	IRegisterService registerServices;
	@Autowired
	IUsersService userService;
	@Autowired
	IRoulettesService rouletteServices;
	
	RoulettesDTO roulette = new RoulettesDTO();
	UsersDTO user = new UsersDTO(); 
	BetsDTO bet = new BetsDTO();
	boolean exito;
	String name,lastName,founds,idRoulette;
	String num = "0";
	
	
	@RequestMapping(value="/Bet/{id}")
	public String update(@PathVariable(value="id") Integer id) {
		roulette.setIdRoulettes(id);
		return "redirect:/BetForm";
	}
	@RequestMapping(value="/BetRoulette", method = RequestMethod.GET)
	public String consult(BetsDTO bets,Model model,Map<String, Object> Model) {
		model.addAttribute("bets",betService.findByid(this.roulette.getIdRoulettes()));
		model.addAttribute("bet", bets);
		Model.put("idOnRoulette",idRoulette);
		Model.put("founds", founds);
		Model.put("firstName",name);
		Model.put("lastName",lastName);
		Model.put("number",this.num.toString());
		if(Integer.parseInt(num)%2 == 0) {
			Model.put("color","roulette bg-danger");
		}else {
			Model.put("color","roulette bg-dark");
		}
		if(exito) {
			Model.put("alert", "alert alert-danger");
		}
		this.exito = false;
		return "BetRoulette";
	}
	@RequestMapping(value="/BetForm")
	public String showId(Map<String, Object> model,Model models) {
		RegisterDTO r = registerServices.findId();
		String id = r.getIdlastUser();
		this.user = userService.findById(id);
		this.user.setIdUser(id);
		name = this.user.getFirstName();
		lastName = this.user.getLastName();
		founds = this.user.getFounds().toString();
		idRoulette = String.valueOf(this.roulette.getIdRoulettes());
		return "redirect:BetRoulette";
	}
	
	@RequestMapping(value="/openBetForm")
	public String createBet(BetsDTO bets,Map<String, Object> model) {
		String redirect="";
		num = betService.generateNumber().toString();
		String color = betService.generateColor(Integer.parseInt(num));
		String bet = bets.getBet();
		bets.setResult(betService.betWin(num, bet, color));
		bets.setIdRoulettesRoulettes(roulette.getIdRoulettes());
		this.bet = bets;
		if(bets.getBetValue() > this.user.getFounds()) {
			this.exito = true;
			redirect = "redirect:BetRoulette";
		}else {
			redirect = "redirect:winLoseForm";
			betService.createBet(bets);
		}
		return redirect;
	}
	@RequestMapping(value="/winLoseForm")
	public String PaymentsForm(UsersDTO user,Map<String,Object> model) {
		
		String typeValue = betService.typeBet(this.bet.getBet());
		Double founds = betService.winOrLose(this.bet.getResult(), typeValue, this.bet.getBetValue(),this.user.getFounds() );
		this.user.setFounds(founds);
		userService.updateFounds(this.user.getIdUser(),this.user.getFounds());
		return "redirect:/BetForm";
	}
}
