package com.test.roulette.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.roulette.entities.Users;

public interface UsersRepository extends CrudRepository<Users, String>{
	@Query(value = "select id_users,email,`password` from users where email= :email",nativeQuery = true)
	public List<Object[]> validateUser(String email);
	@Query(value = "select email,first_name,last_name,founds from users where id_users = :id",nativeQuery = true)
	public List<Object[]> findId(String id);
}
 