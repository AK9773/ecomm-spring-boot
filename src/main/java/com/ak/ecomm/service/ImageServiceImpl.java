package com.ak.ecomm.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ak.ecomm.entity.Image;
import com.ak.ecomm.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image uploadImage(String path, MultipartFile file) {

		// file name
		String name = file.getOriginalFilename();

		// full path
		String filePath = path + File.separator + name;

		// create folder if not created
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();

		}

		// file copy
		try {
			Files.copy(file.getInputStream(), Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imageRepository.save(new Image(name));
	}

}
