package com.ak.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

}
