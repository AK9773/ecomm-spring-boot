package com.ak.ecomm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	
	Optional<Image> findByImageName(String fileName);

}
