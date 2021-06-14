package com.test.roulette.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.dto.RegisterDTO;
import com.test.roulette.entities.Register;
import com.test.roulette.repositories.RegisterRepository;
import com.test.roulette.services.IRegisterService;

@Service
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private RegisterRepository repo;

	@Override
	public void save(String id) {
		Register r = new Register();
		r.setIdlastUser(id);
		repo.save(r);
	}

	@Override
	public RegisterDTO findId() {
		List<Object[]> lstid = repo.findId();
		List<RegisterDTO> lstRegister = new ArrayList<RegisterDTO>();
		for(Object[] obj : lstid) {
			RegisterDTO r = new RegisterDTO();
			r.setIdlastUser(obj[1].toString());
			lstRegister.add(r);
		}
		RegisterDTO r = new RegisterDTO();
		for(RegisterDTO re : lstRegister) {
			r.setIdlastUser(re.getIdlastUser());
		}
		return r;
	}
	
	
}
