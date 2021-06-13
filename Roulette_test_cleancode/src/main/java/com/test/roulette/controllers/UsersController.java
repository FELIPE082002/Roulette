package com.test.roulette.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.dto.UsersDTO;
import com.test.roulette.services.IUsersService;

@Controller
public class UsersController {
	@Autowired
	private IUsersService userService;
	
	@RequestMapping(value="/FindUsers", method = RequestMethod.GET)
	public String consult(Model model) {
		model.addAttribute("users",userService.findAll());
		return "FindUsers";
	}
	
	@RequestMapping(value="/Login")
	public String crear(Map<String, Object> model){
		UsersDTO user = new UsersDTO();
		model.put("title", "Login");
		model.put("users", user);
		return "Login";
	}
	@RequestMapping(value="/LoginForm", method=RequestMethod.POST)
	public String save(UsersDTO user) {
		String uniqueID = UUID.randomUUID().toString();
		System.out.print(uniqueID);
		user.setIdUser(uniqueID);
		user.setFounds(0);
		userService.save(user);
		return "redirect:FindUsers";
	}
	

}
