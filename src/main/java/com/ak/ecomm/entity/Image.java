package com.ak.ecomm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {
	@Id
	private String image;

	public Image() {
		super();
	}

	public Image(String image) {
		super();
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "image [image=" + image + "]";
	}

}
