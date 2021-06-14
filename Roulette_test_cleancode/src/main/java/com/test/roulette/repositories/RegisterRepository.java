package com.test.roulette.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.roulette.entities.Register;

public interface RegisterRepository extends CrudRepository<Register, Integer>{
	@Query(value="SELECT * FROM register ORDER BY id_register DESC LIMIT 0,1", nativeQuery = true)
	public List<Object[]> findId();
		
}
