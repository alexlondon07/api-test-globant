package com.springboot.backend.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.backend.apirest.models.entity.Category;	

public interface ICategoryDao extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
	
	Optional<Category> findByCodeCategory(String code);
}
