package com.demo.onlineshop.entity;

public enum CatergoryType {
	WOODWORKING("Woodworking"),TOOLS("Tools"),GARDEN("Garden"),AUTOMOTIVE("Automotive"),BRICOLAGE("Bricolage");

	private String category;

	private CatergoryType(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}
