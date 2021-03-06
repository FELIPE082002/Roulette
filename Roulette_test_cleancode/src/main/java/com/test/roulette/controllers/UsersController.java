package com.test.roulette.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.dto.SignInDTO;
import com.test.roulette.dto.UsersDTO;
import com.test.roulette.services.IRegisterService;
import com.test.roulette.services.IUsersService;

@Controller
public class UsersController {
	
	SignInDTO userSesion = new SignInDTO();
	UsersDTO user = new UsersDTO();	
	
	@Autowired
	private IUsersService userService;
	@Autowired
	private IRegisterService registerService;
	
	@RequestMapping(value="/FindUsers", method = RequestMethod.GET)
	public String consult(Model model) {
		model.addAttribute("users",userService.findAll());
		return "FindUsers";
	}

	@RequestMapping(value="/Login")
	public String create(Map<String, Object> model){
		UsersDTO user = new UsersDTO();
		model.put("title", "Login");
		model.put("users", user);
		return "Login";
	}
	@RequestMapping(value="/LoginForm", method=RequestMethod.POST)
	public String save(UsersDTO user,Map<String,Object> model) {
		String Redirect = "";
		String uniqueID = UUID.randomUUID().toString();
		user.setIdUser(uniqueID);
		user.setFounds(0.0);
		if(user.getPassword() != "" && user.getEmail() != "") {
			userService.save(user);
			Redirect = "redirect:SignIn";
		}else {
			Redirect="redirect:Login";
		}
		return Redirect;
	}
	
	@RequestMapping(value="/SignIn")
	public String enter(Map<String,Object> model){
		SignInDTO user = new  SignInDTO();
		model.put("user", user);
		return "SignIn";
	}
	
	@RequestMapping(value="/SignInForm",method=RequestMethod.POST)
	public String validate(SignInDTO user,Model model) {
		String Redirect = "";
		SignInDTO s = userService.validateUser(user.getvEmail());
		this.userSesion = s;
		if ( s.getEmail().equals(user.getvEmail()) && s.getPassword().equals(user.getvPassword())) {
			registerService.save(s.getId());
			Redirect = "redirect:HomeForm";
		}else {
			Redirect="redirect:SignIn";
		}
		return Redirect;
	}
	
}
