package com.ak.ecomm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imageId;
	private String imageName;
	private String type;
	@Lob
	@Column(length = 10000000)
	private byte[] imageBytes;

	public Image(String imageName) {
		super();
		this.imageName = imageName;
	}

}
