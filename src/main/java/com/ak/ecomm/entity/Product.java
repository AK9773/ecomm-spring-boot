package com.ak.ecomm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "Product.searchProduct", query = "select * from product where product_name like concat(?1,'%') or category like concat(?1,'%') ", resultClass = Product.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private int price;
	private String color;
	private String category;
	private String image;
	private String description;
	private int sellerId;

	public Product() {
		super();

	}
	
	public Product(String productName, int price, String color, String category, String image,
			String description, int sellerId) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.category = category;
		this.image = image;
		this.description = description;
		this.sellerId = sellerId;
	}
	


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", category=" + category + ", image=" + image + ", description=" + description + ", sellerId="
				+ sellerId + "]";
	}

	

}
