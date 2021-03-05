package com.demo.onlineshop.service;

import java.util.List;
import java.util.Optional;

import com.demo.onlineshop.entity.User;

public interface IUserService {
	public List<User> getAllUser();
	public Optional<User> getUser(Long id);
	public List<User> findByUsernameList(String username);
}
