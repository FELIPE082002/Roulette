package com.test.roulette.services.impl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.roulette.dto.SignInDTO;
import com.test.roulette.dto.UsersDTO;
import com.test.roulette.entities.Users;
import com.test.roulette.repositories.UsersRepository;
import com.test.roulette.services.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {
	
	public static final Integer COL_ID_USER = 0;
	public static final Integer COL_EMAIL = 1;
	public static final Integer COL_PASSWORD = 2;
	
	
	
	@Autowired
	private UsersRepository repo;

	@Override
	public List<UsersDTO> findAll() {
		List<UsersDTO> lstUsersDTO = new ArrayList<>();
		List<Users> lstUsers = (List<Users>) repo.findAll();
		for(Users u : lstUsers) {
			UsersDTO user = new UsersDTO();
			user.setIdUser(u.getIdUser());
			user.setEmail(u.getEmail());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setFounds(u.getFounds());
			user.setPassword(u.getPassword());
			lstUsersDTO.add(user);
		}
		return lstUsersDTO;
	}

	@Override
	public void save(UsersDTO user) {
		Users u = new Users();
		u.setFirstName(user.getFirstName());
		u.setIdUser(user.getIdUser());
		u.setLastName(user.getLastName());
		u.setPassword(user.getPassword());
		u.setFounds(user.getFounds());
		u.setEmail(user.getEmail());
		repo.save(u);
	}

	@Override
	public SignInDTO validateUser(String email) {
		List<Object[]> list = repo.validateUser(email);
		List<SignInDTO> lstSignIn = new ArrayList<SignInDTO>();
		for(Object[] obj : list) {
			SignInDTO s = new SignInDTO();
			s.setId(obj[COL_ID_USER].toString());
			s.setEmail(obj[COL_EMAIL].toString());
			s.setPassword(obj[COL_PASSWORD].toString());
			lstSignIn.add(s);
		}
		SignInDTO s = new SignInDTO();
		for(SignInDTO obj :lstSignIn) {
			s.setId(obj.getId());
			s.setEmail(obj.getEmail());
			s.setPassword(obj.getPassword());
		}
		
		return s;
	}

	@Override
	public UsersDTO findById(String id) {
		List<Users> user = repo.findId(id); 
		UsersDTO U = new UsersDTO();
		for(Users u : user) {
			U.setEmail(u.getEmail());
			U.setFirstName(u.getFirstName());
			U.setLastName(u.getLastName());
			U.setFounds(u.getFounds());
		}		
		return U;
	}

}
