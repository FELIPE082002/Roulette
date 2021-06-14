package com.test.roulette.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.test.roulette.entities.Roulettes;

public interface RoulettesRepository extends CrudRepository<Roulettes, String>{
	@Modifying
	@Query(value="UPDATE roulettes set status = false where id_roulettes = :id",nativeQuery = true)
	void updateRoulette(@Param(value="id") Integer id);
}
