package com.test.roulette.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.roulette.services.IRoulettesService;

@Controller
public class RouletteController {
	@Autowired
	private IRoulettesService roulleteService;
	
	@RequestMapping(value="/Home")
	public String Home() {
		return "Home";
	}
}
