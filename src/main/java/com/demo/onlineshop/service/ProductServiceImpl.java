package com.demo.onlineshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.onlineshop.entity.Product;
import com.demo.onlineshop.persistence.repository.ProductRepository;

@Service
@Transactional
@Repository
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> findByNameList(String name) {
		return productRepository.findByName(name);
	}
	@Override
	public List<Product> getAllPro() {
		return productRepository.findAll();
	}
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}
	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}
	@Override
	public void saveProduct(Product storedProduct) {
		productRepository.saveAndFlush(storedProduct);
		
	}

}