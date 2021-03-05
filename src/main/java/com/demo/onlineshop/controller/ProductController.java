package com.demo.onlineshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlineshop.entity.Product;
import com.demo.onlineshop.entity.User;
import com.demo.onlineshop.entity.UserType;
import com.demo.onlineshop.persistence.repository.ProductRepository;
import com.demo.onlineshop.persistence.repository.UserRepository;
import com.demo.onlineshop.service.IProductService;
import com.demo.onlineshop.service.IUserService;
import com.demo.onlineshop.spring.GenericResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product/")
@ApiOperation(value = "Product controller for online demo store.")
public class ProductController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	IUserService iUserService;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	IProductService iProductService;

	@ApiOperation(value = "Get all users. Request allowed only for employees")
	@RequestMapping(value = "/allUser{userID}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(@PathVariable("userID") Long userId) {
		Optional<User> user = iUserService.getUser(userId);
		if (user.isPresent() && user.get().getUserType().equals(UserType.EMPLOYEE)) {
		     List<User> allUser = iUserService.getAllUser();
		     return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
		} else if (user.isPresent() && user.get().getUserType().equals(UserType.CUSTOMER)) {
			return new ResponseEntity<String>("Access denied", HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<String>("User Not Found", HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Get all users. Request allowed for all users")
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = iProductService.getAllPro();
		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
	}

	@ApiOperation(value = "Add a new product. Request allowed only for employees")
	@RequestMapping(value = "/add/{userID}", method = RequestMethod.POST, produces = "application/json")
	public GenericResponse saveProduct(@PathVariable("userID") Long userId, @RequestBody Product product) {
		Optional<User> user = iUserService.getUser(userId);
		if (user.isPresent() && user.get().getUserType().equals(UserType.EMPLOYEE)) {
			try {
				product.setId(null);//@GeneratedValue(strategy = GenerationType.AUTO)
				iProductService.saveProduct(product);
				return new GenericResponse("Product saved successfully", HttpStatus.OK);
			} catch (Exception e) {
				return new GenericResponse("Error while adding product", e.getMessage());
			}
		} else if (user.isPresent() && user.get().getUserType().equals(UserType.CUSTOMER)) {
			return new GenericResponse("Access denied", HttpStatus.FORBIDDEN);
		} else {
			return new GenericResponse("User Not Found", HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Edit a product. Request allowed only for employees")
	@RequestMapping(value = "/update/{userID}/{proID}", method = RequestMethod.PUT, produces = "application/json")
	public GenericResponse updateProduct(@PathVariable("userID") Long userId, @PathVariable("proID") Long proId, @RequestBody Product product) {
		Optional<User> user = iUserService.getUser(userId);
		if (user.isPresent() && user.get().getUserType().equals(UserType.EMPLOYEE)) {
			try {
				Product editProduct = (iProductService.getProductById(proId).isPresent()?iProductService.getProductById(proId).get():null);
				if (editProduct!=null) {
					editProduct.setName(product.getName());
					editProduct.setCatergoryType(product.getCatergoryType());
					editProduct.setDescription(product.getDescription());
					editProduct.setLastModifiedBy(product.getLastModifiedBy());
					editProduct.setLastModifiedDate(product.getLastModifiedDate());
					editProduct.setQuantity(product.getQuantity());
					iProductService.saveProduct(editProduct);
					return new GenericResponse("Product updated successfully", HttpStatus.OK);	
				}else {
					return new GenericResponse("The product doesn't exist", HttpStatus.BAD_REQUEST);	
				}
				
			} catch (Exception e) {
				return new GenericResponse("Error while edit product", e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else if (user.isPresent() && user.get().getUserType().equals(UserType.CUSTOMER)) {
			return new GenericResponse("Access denied", HttpStatus.FORBIDDEN);
		} else {
			return new GenericResponse("User Not Found", HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Delete a product. Request allowed only for employees")
	@RequestMapping(value = "/delete/{userID}/{proID}", method = RequestMethod.DELETE, produces = "application/json")
	public GenericResponse delete(@PathVariable("userID") Long userId, @PathVariable("proID") Long proId) {
		Optional<User> user = iUserService.getUser(userId);
		if (user.isPresent() && user.get().getUserType().equals(UserType.EMPLOYEE)) {
			try {
				iProductService.deleteProduct(proId);
				return new GenericResponse("Product deleted successfully", HttpStatus.OK);
			} catch (Exception e) {
				return new GenericResponse("Error while deleting product. Product may not exist", e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else if (user.isPresent() && user.get().getUserType().equals(UserType.CUSTOMER)) {
			return new GenericResponse("Access denied", HttpStatus.FORBIDDEN);
		} else {
			return new GenericResponse("User Not Found", HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Order a product. Request allowed for all users")
	@RequestMapping(value = "/order/{proID}/{qty}", method = RequestMethod.GET, produces = "application/json")
	public GenericResponse orderProduct(@PathVariable("proID") Long proId, @PathVariable("qty") Integer qty) {
		Product orderProduct = (iProductService.getProductById(proId).isPresent()?iProductService.getProductById(proId).get():null);
		if (orderProduct!=null&&qty>0) {
			return new GenericResponse("Order completed", HttpStatus.OK);
		}else {
			return (orderProduct==null?new GenericResponse("Product not found", HttpStatus.BAD_REQUEST):qty<=0?new GenericResponse("Quantity must be greater than zero", HttpStatus.BAD_REQUEST):null);
		}
		
	}

}
