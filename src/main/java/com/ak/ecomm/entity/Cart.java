package com.ak.ecomm.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedNativeQuery;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private String productName;
	private String price;
	private String color;
	private String category;
	private String description;
	private int quantity;
	private int userId;
	private int productId;
	private String imageName;

	public Cart() {
		super();
	}

	public Cart(String productName, String price, String color, String category, String description, int quantity,
			int userId, int productId, String imageName) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
		this.userId = userId;
		this.productId = productId;
		this.imageName = imageName;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productName=" + productName + ", price=" + price + ", color=" + color
				+ ", category=" + category + ", description=" + description + ", quantity=" + quantity + ", userId="
				+ userId + ", productId=" + productId + ", imageName=" + imageName + "]";
	}

}
