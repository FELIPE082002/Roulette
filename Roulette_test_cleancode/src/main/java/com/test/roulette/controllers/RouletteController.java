package com.test.roulette.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.services.IRoulettesService;
import com.test.roulette.services.IUsersService;

@Controller
public class RouletteController {
	@Autowired
	IRoulettesService rouleteServices;
	@Autowired
	IUsersService userServices;
	
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String consult(Model model) {
		model.addAttribute("roulette",rouleteServices.findAll());
		return "Home";
	}
}
