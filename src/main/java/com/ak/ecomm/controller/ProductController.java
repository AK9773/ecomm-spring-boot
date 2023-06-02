package com.ak.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.Product;
import com.ak.ecomm.service.ProductService;

@RestController
@RequestMapping(value = "/product-api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/productId={productId}")
	public Product getProduct(@PathVariable int productId) {
		return productService.getProduct(productId);
	}

	@PutMapping(value = "/product/productId={productId}")
	public void updateProduct(@PathVariable int productId,@RequestBody Product product) {
		productService.updateProduct(productId, product);

	}

	@DeleteMapping(value = "/product/productId={productId}")
	public void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}
	
	@GetMapping("/product/sellerId={sellerId}")
	public List<Product> findBySellerId(@PathVariable int sellerId){
		return productService.findBySellerId(sellerId);
	}
	
	
	@GetMapping(value = "/product/query={query}")
	public List<Product> searchProduct(@PathVariable String query){
		return productService.searchProduct(query);
	}
	
	

}