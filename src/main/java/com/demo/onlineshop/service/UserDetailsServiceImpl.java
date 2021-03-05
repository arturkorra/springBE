package com.demo.onlineshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.onlineshop.entity.User;
import com.demo.onlineshop.persistence.repository.UserRepository;

@Service
@Transactional
@Repository
public class UserDetailsServiceImpl implements UserDetailsService, IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public List<com.demo.onlineshop.entity.User> findByUsernameList(String username) {
		List<com.demo.onlineshop.entity.User> allUserWithName = userRepository.findByusername("admin");
		return allUserWithName;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
}