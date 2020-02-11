package com.claim_academy.capstone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claim_academy.capstone.model.Users;



public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

	@Query("FROM Users WHERE email=?1")
	Optional<Users> findEmail(String email);

	@Query("FROM Users WHERE lastname=?1 OR firstname=?1 OR email=?1")
	List<Users> findBylastName(String lname);

	@Query("FROM Users WHERE lastname=?1 OR firstname=?1")
	List<Users> findByName(String name);
}
