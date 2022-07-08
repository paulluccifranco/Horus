package com.service;

import com.model.User;

public interface UserService {

	public User saveUser(String name);

	public User findUserById(int id);

}
