package com.test.roulette.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.test.roulette.entities.Users;

public interface UsersRepository extends CrudRepository<Users, String>{
	@Query(value = "select id_users,email,`password` from users where email= :email",nativeQuery = true)
	public List<Object[]> validateUser(String email);
	@Query(value = "select email,first_name,last_name,founds from users where id_users = :id",nativeQuery = true)
	public List<Object[]> findId(String id);
	@Modifying
	@Query(value="UPDATE users SET founds = :amount WHERE id_users = :id",nativeQuery = true)
	void updateFounds(@Param(value="id") String id,@Param(value="amount") Double amount);
}
 