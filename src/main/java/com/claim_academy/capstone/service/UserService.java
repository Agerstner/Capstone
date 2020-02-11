package com.claim_academy.capstone.service;

import java.util.List;
import java.util.Optional;

import com.claim_academy.capstone.model.Users;



public interface UserService {

	Optional<Users> findById(long id);
	void delete(long id);
	void save(Users users);
	void update(Users users);
	List<Users> findAll();
	Optional<Users> findByEmail(String email);
	List<Users> findByLastname(String lastname);
}
