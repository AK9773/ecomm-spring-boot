package com.ak.ecomm.service;

import org.springframework.web.multipart.MultipartFile;

import com.ak.ecomm.entity.Image;

public interface ImageService {
	
	public Image uploadImage(String path, MultipartFile file);

}
