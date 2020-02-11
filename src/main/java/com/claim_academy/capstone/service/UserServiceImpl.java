package com.claim_academy.capstone.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim_academy.capstone.model.Users;
import com.claim_academy.capstone.repository.UserRepository;



@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Optional<Users> findByEmail(String email) {
		return repository.findEmail(email);
	}

	@Override
	public List<Users> findByLastname(String lastname) {
		return repository.findBylastName(lastname);
	}

	@Override
	public Optional<Users> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public void save(Users users) {
		repository.save(users);
	}

	@Override
	public void update(Users users) {
		Users user = findById(users.getId()).get();
		if (user != null) {
			user.setFirstname(users.getFirstname());
			user.setLastname(users.getLastname());
			user.setPhone(users.getPhone());
		}
	}

	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

}
