package com.ak.ecomm.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@NamedNativeQuery(name = "Product.searchProduct", query = "select * from product where product_name like concat(?1,'%') or category like concat(?1,'%') ", resultClass = Product.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private int price;
	private String color;
	private String category;
	@Column(length = 2000)
	private String description;
	private int sellerId;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "product_image", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "image_id") })
	private Set<Image> productImages;

	public Product() {
		super();
	}

	public Product(String productName, int price, String color, String category, String description, int sellerId) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.category = category;
		this.description = description;
		this.sellerId = sellerId;
	}

	public Set<Image> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<Image> productImages) {
		this.productImages = productImages;
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
				+ color + ", category=" + category + ", description=" + description + ", sellerId=" + sellerId
				+ ", productImages=" + productImages + "]";
	}

}
