package com.demo.onlineshop.entity;

public enum UserType {
	CUSTOMER("Customer"),EMPLOYEE("Employee");

	private String name;

	private UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

