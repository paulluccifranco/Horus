package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
import com.repository.UserRepo;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User saveUser(String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
	}

	@Override
	public User findUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}

}
