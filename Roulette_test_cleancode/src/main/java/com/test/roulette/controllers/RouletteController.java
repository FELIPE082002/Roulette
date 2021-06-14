package com.test.roulette.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.dto.RegisterDTO;
import com.test.roulette.dto.SignInDTO;
import com.test.roulette.dto.UsersDTO;
import com.test.roulette.services.IRegisterService;
import com.test.roulette.services.IRoulettesService;
import com.test.roulette.services.IUsersService;

@Controller
public class RouletteController{
	
	UsersDTO user = new UsersDTO(); 
	SignInDTO userSesion = new SignInDTO();
	
	@Autowired
	IRoulettesService rouleteServices;
	@Autowired
	IRegisterService registerServices;
	@Autowired
	IUsersService userService;
	
	String name,lastName,founds;
	
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String consult(Model model,Map<String, Object> Model) {
		model.addAttribute("roulette",rouleteServices.findAll());
		Model.put("founds", founds);
		Model.put("firstName",name);
		Model.put("lastName",lastName);
		return "Home";
	}
	
	@RequestMapping(value="/HomeForm")
	public String showId(Map<String, Object> model,Model models) {
		RegisterDTO r = registerServices.findId();
		String id = r.getIdlastUser();
		this.user = userService.findById(id);
		name = this.user.getFirstName();
		lastName = this.user.getLastName();
		founds = this.user.getFounds().toString();
		return "redirect:Home";
	}
	
}
