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
	
	String name,lastName,founds,idRoulette;
	
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
		String num = betService.generateNumber().toString();
		String color = betService.generateColor(Integer.parseInt(num));
		String bet = bets.getBet();
		if(bet.equals(num) || bet.equals(color) ) {
			bets.setResult("WIN");
		}
		else {
			bets.setResult("LOSE");
		}
		bets.setIdRoulettesRoulettes(roulette.getIdRoulettes());
		betService.createBet(bets);
		return "redirect:BetRoulette";
	}
	
}
