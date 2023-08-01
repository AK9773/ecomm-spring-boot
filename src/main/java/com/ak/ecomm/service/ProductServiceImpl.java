package com.ak.ecomm.service;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ak.ecomm.entity.Image;
import com.ak.ecomm.entity.Product;
import com.ak.ecomm.repository.ProductRepository;
import com.ak.ecomm.util.ImageUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product, MultipartFile[] files) {
		try {
			Set<Image> uploadImages = uploadImages(files);
			product.setProductImages(uploadImages);
			return productRepository.save(product);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Image uploadThumbnail(MultipartFile file) throws IOException {
			String string = LocalTime.now().toString();
			Image image = Image.builder().imageName(string+file.getOriginalFilename()).type(file.getContentType()).imageBytes(ImageUtils.compressImage(file.getBytes())).build();
		return image;
	}
	
	public Set<Image> uploadImages(MultipartFile[] multipartFiles) throws IOException {
		Set<Image> images = new HashSet<>();
		for (MultipartFile file : multipartFiles) {
			String string = LocalTime.now().toString();
			Image image = Image.builder().imageName(string+file.getOriginalFilename()).type(file.getContentType()).imageBytes(ImageUtils.compressImage(file.getBytes())).build();
			images.add(image);
		}
		return images;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		return productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> findBySellerId(int sellerId) {
		return productRepository.findBySellerId(sellerId);
	}

	@Override
	public List<Product> searchProduct(String query) {
		return productRepository.searchProduct(query);
	}

}
