package com.test.roulette.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.test.roulette.entities.Bets;

public interface BetsRepository extends CrudRepository<Bets, String>{
	@Query(value = "SELECT id_bet,bet_value,bet,result from bets where id_roulettes_roulettes = :id",nativeQuery = true)
	public List<Object[]> betsByUser(@Param(value="id") Integer id);
}
