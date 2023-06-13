package com.ak.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ak.ecomm.entity.Image;
import com.ak.ecomm.service.ImageService;

@RestController
@RequestMapping(value = "/image-api")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
	@Autowired
	private ImageService imageService;

	@Value("${project.image}")
	private String path;

	@PostMapping(value = "/image")
	public ResponseEntity<Image> imageUpload(@RequestParam("image") MultipartFile image) {
		Image uploadImage = imageService.uploadImage(path, image);
		return new ResponseEntity<Image>(uploadImage, HttpStatus.CREATED);
	}
}
