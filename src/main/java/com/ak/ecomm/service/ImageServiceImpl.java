package com.ak.ecomm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Image;
import com.ak.ecomm.repository.ImageRepository;
import com.ak.ecomm.util.ImageUtils;


@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	public byte[] downloadImage(String fileName) {
       Optional<Image> findByImageName = imageRepository.findByImageName(fileName);
        byte[] images = ImageUtils.decompressImage(findByImageName.get().getImageBytes());
        return images;
    }

}
