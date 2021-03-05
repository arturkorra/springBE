package com.demo.onlineshop.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.onlineshop.entity.User;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);
	public List<User> findByusername(String username);
}