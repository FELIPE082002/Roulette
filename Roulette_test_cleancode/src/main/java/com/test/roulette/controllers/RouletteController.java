package com.test.roulette.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.roulette.dto.RegisterDTO;
import com.test.roulette.dto.RoulettesDTO;
import com.test.roulette.dto.UsersDTO;
import com.test.roulette.services.IRegisterService;
import com.test.roulette.services.IRoulettesService;
import com.test.roulette.services.IUsersService;

@Controller
public class RouletteController{
	
	UsersDTO user = new UsersDTO(); 
	
	
	@Autowired
	IRoulettesService rouletteServices;
	@Autowired
	IRegisterService registerServices;
	@Autowired
	IUsersService userService;
	
	String name,lastName,founds;
	
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String consult(Model model,Map<String, Object> Model) {
		model.addAttribute("roulette",rouletteServices.findByid(this.user.getIdUser()));
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
		this.user.setIdUser(id);
		name = this.user.getFirstName();
		lastName = this.user.getLastName();
		founds = this.user.getFounds().toString();
		return "redirect:Home";
	}
	@RequestMapping(value="/RouletteForm")
	public String save(RoulettesDTO r) {
		r.setStatus(true);
		r.setIdUsers_Users(this.user.getIdUser());
		rouletteServices.save(r);
		return "redirect:Home";
	}
	@RequestMapping(value="/UpdateForm/{id}")
	public String update(@PathVariable(value="id") Integer id) {
		rouletteServices.update(id);
		return "redirect:/Home";
	}
	@RequestMapping(value="/Pay")
	public String Payments(UsersDTO user,Map<String, Object> model,Model Model) {
		Model.addAttribute("user",user);
		model.put("title", "Add Founds");
		return "Pay";
	}
	
	@RequestMapping(value="/PayForm")
	public String PaymentsForm(UsersDTO user,Map<String,Object> model) {
		double founds= this.user.getFounds() + user.getFounds() ;
		this.user.setFounds(founds);
		userService.updateFounds(this.user.getIdUser(),this.user.getFounds());
		return "redirect:HomeForm";
	}
}
