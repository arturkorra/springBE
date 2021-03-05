package com.demo.onlineshop.spring;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.onlineshop.entity.CatergoryType;
import com.demo.onlineshop.entity.Product;
import com.demo.onlineshop.entity.User;
import com.demo.onlineshop.entity.UserType;
import com.demo.onlineshop.persistence.repository.ProductRepository;
import com.demo.onlineshop.persistence.repository.UserRepository;
import com.demo.onlineshop.service.IProductService;
import com.demo.onlineshop.service.IUserService;

@Component
public class AddDataToDatabase implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	IUserService iUserService;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	IProductService iProductService;

	@Override
	public void run(String... args) throws Exception {
		List<User> allUsers = iUserService.getAllUser();
		if (allUsers.size() == 0) {
			for (int i = 1; i < 3; i++) {
				User addUser = new User();
				addUser.setUsername("emp" + i);
				addUser.setLastname("empsur" + i);
				addUser.setUserType(UserType.EMPLOYEE);
				userRepository.save(addUser);
			}
			for (int j = 1; j < 4; j++) {
				User addUser = new User();
				addUser.setUsername("cus" + j);
				addUser.setLastname("cussur" + j);
				addUser.setUserType(UserType.CUSTOMER);
				userRepository.save(addUser);
			}
		}
		List<Product> allProducts = iProductService.getAllPro();
		if (allProducts.size() == 0) {
			for (int i = 1; i < 3; i++) {
				Product addProduct = new Product();
				addProduct.setName("pro"+i);
				addProduct.setQuantity(i+10);
				addProduct.setDescription("Product Example"+i);
				addProduct.setUuid(UUID.randomUUID().toString());
				addProduct.setCatergoryType(CatergoryType.AUTOMOTIVE);
				addProduct.setCreatedDate(new Date());
				addProduct.setLastModifiedDate(new Date());
				addProduct.setCreatedBy("Auto");
				addProduct.setLastModifiedBy("Auto");
				productRepository.save(addProduct);
			}
			for (int j = 1; j < 3; j++) {
				Product addProduct = new Product();
				addProduct.setName("pro"+j);
				addProduct.setQuantity(j+10);
				addProduct.setDescription("Product Example"+j);
				addProduct.setUuid(UUID.randomUUID().toString());
				addProduct.setCatergoryType(CatergoryType.BRICOLAGE);
				addProduct.setCreatedDate(new Date());
				addProduct.setLastModifiedDate(new Date());
				addProduct.setCreatedBy("Auto");
				addProduct.setLastModifiedBy("Auto");
				productRepository.save(addProduct);
			}
			for (int k = 1; k < 3; k++) {
				Product addProduct = new Product();
				addProduct.setName("pro"+k);
				addProduct.setQuantity(k+10);
				addProduct.setDescription("Product Example"+k);
				addProduct.setUuid(UUID.randomUUID().toString());
				addProduct.setCatergoryType(CatergoryType.GARDEN);
				addProduct.setCreatedDate(new Date());
				addProduct.setLastModifiedDate(new Date());
				addProduct.setCreatedBy("Auto");
				addProduct.setLastModifiedBy("Auto");
				productRepository.save(addProduct);
			}
			for (int l = 1; l < 3; l++) {
				Product addProduct = new Product();
				addProduct.setName("pro"+l);
				addProduct.setQuantity(l+10);
				addProduct.setDescription("Product Example"+l);
				addProduct.setUuid(UUID.randomUUID().toString());
				addProduct.setCatergoryType(CatergoryType.TOOLS);
				addProduct.setCreatedDate(new Date());
				addProduct.setLastModifiedDate(new Date());
				addProduct.setCreatedBy("Auto");
				addProduct.setLastModifiedBy("Auto");
				productRepository.save(addProduct);
			}
			for (int m = 1; m < 3; m++) {
				Product addProduct = new Product();
				addProduct.setName("pro"+m);
				addProduct.setQuantity(m+10);
				addProduct.setDescription("Product Example"+m);
				addProduct.setUuid(UUID.randomUUID().toString());
				addProduct.setCatergoryType(CatergoryType.WOODWORKING);
				addProduct.setCreatedDate(new Date());
				addProduct.setLastModifiedDate(new Date());
				addProduct.setCreatedBy("Auto");
				addProduct.setLastModifiedBy("Auto");
				productRepository.save(addProduct);
			}
		}
	}
}