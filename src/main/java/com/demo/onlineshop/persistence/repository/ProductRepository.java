package com.demo.onlineshop.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.onlineshop.entity.Product;
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByName(String name);
}