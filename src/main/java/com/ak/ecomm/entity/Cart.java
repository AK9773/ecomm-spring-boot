package com.ak.ecomm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private String name;
	private String price;
	private String color;
	private String category;
	private String image;
	private String description;
	private int quantity;
	private int userId;
	private int productId;

	public Cart() {
		super();
	}

	public Cart(String name, String price, String color, String category, String image, String description,
			int quantity, int userId, int productId) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
		this.category = category;
		this.image = image;
		this.description = description;
		this.quantity = quantity;
		this.userId = userId;
		this.productId = productId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", name=" + name + ", price=" + price + ", color=" + color + ", category="
				+ category + ", image=" + image + ", description=" + description + ", quantity=" + quantity
				+ ", userId=" + userId + ", productId=" + productId + "]";
	}

}
